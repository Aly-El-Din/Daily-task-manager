package com.example.demo.Service;

import com.example.demo.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.io.*;
import java.util.HashMap;
import java.util.regex.*;


@Component
public class Authentication {


    private HashMap<String,String> Users = new HashMap<>();

    private Database database;

    @Autowired
    public Authentication(HashMap<String, String> users,Database database) {
        this.Users = new HashMap<>();
        this.database= Database.getInstance();
    }
    public Authentication(){

        this.database= Database.getInstance();
    }

    public HashMap<String, String> getUsers() {
        return Users;
    }

    public void setUsers(HashMap<String, String> users) {
        this.Users = users;
    }

    //authenticate logins
    public String validate(User user) {
        load();
        database.load();
        if (Users.containsKey(user.getUserName())) {// expected to return list of data
            if (Users.get(user.getUserName()).equals( user.getPassword())) {

                return "Success";
            } else throw new RuntimeException("Wrong password");
        }
        else throw new RuntimeException("Wrong username");
    }

    //On sign up
    public String createAccount(User user) {

        load();
        try {
            if (isUsernameValid(user.getUserName()) && isPasswordValid(user.getPassword())) {
                Users.put(user.getUserName(), user.getPassword());
                database.getDatabase().put(user.getUserName(), user);
                database.save();
                save(Users);
                return "welcome";
            }

        } catch(Exception e){
            return e.getMessage();
        }

        return null;
    }



    //put constraint on the password before approving

    public boolean isUsernameValid(String username){
        if(Users.containsKey(username)){
            throw new RuntimeException("Username already in use");
        }
        return true;
    }
    public  boolean isPasswordValid(String password) {
        // Check minimum length
        if (password.length() < 8) {
            throw new RuntimeException("Password must be at least 8 characters long.");
        }
        // Check for at least one uppercase letter
        if (!password.matches(".*[A-Z].*")) {
            throw new RuntimeException("Password must contain at least one uppercase letter.");
        }
        // Check for at least one lowercase letter
        if (!password.matches(".*[a-z].*")) {
            throw new RuntimeException("Password must contain at least one lowercase letter.");

        }
        // Check for at least one digit
        if (!password.matches(".*\\d.*")) {
            throw new RuntimeException("Password must contain at least one digit.");

        }
        // Check for at least one special character
        Pattern specialCharPattern = Pattern.compile("[!@#$%^&*()_+=\\-\\[\\]{};:'\"<>,.?/~`]");
        Matcher matcher = specialCharPattern.matcher(password);
        if (!matcher.find()) {
            throw new RuntimeException("Password must contain at least one special character.");

        }
        // If all criteria are met, the password is valid
        return true;
    }
    //Load hashmap of registered accounts from file
    public  HashMap<String, String> load() {
        String filename="C:\\Users\\Cyber\\Desktop\\json dir\\users";
        HashMap<String, String> hashmap = new HashMap<>();
        try (FileInputStream fileIn = new FileInputStream(filename);
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
            // Read the HashMap from the file
            hashmap = (HashMap<String, String>) objectIn.readObject();
            System.out.println("HashMap successfully loaded from " + filename);
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading HashMap from " + filename + ": " + e.getMessage());
        }
        hashmap.remove("");
        setUsers((HashMap<String, String>) hashmap.clone());
        return Users;
    }
    // Save hashmap of usernames into file
    public void save(HashMap<String, String> hashmap) {
        String filename="C:\\Users\\Cyber\\Desktop\\json dir\\users";
        try {
            FileOutputStream fileOut = new FileOutputStream(filename);

            System.out.println(hashmap.isEmpty());
            System.out.println(hashmap.get("sahar"));
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut) ;
            objectOut.writeObject(hashmap);
            System.out.println("HashMap successfully written to " + filename);
        } catch (IOException e) {
            System.err.println("Error writing HashMap to " + filename + ": " + e.getMessage());
        }

    }

}