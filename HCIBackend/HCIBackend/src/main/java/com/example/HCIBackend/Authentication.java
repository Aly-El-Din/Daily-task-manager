package com.example.HCIBackend;

import org.springframework.stereotype.Component;
import java.io.*;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class Authentication {
    private HashMap<String,String> Database;

    public Authentication(HashMap<String, String> database) {
        this.Database = database;
    }

    //authenticate logins
    public String validate(User user) {
        if (Database.containsKey(user.getUserName())) {// expected to return list of data
            if (Database.get(user.getUserName()).equals( user.getPassword())) {
                return "Success";
            } else throw new RuntimeException("Wrong password");
        }
        else throw new RuntimeException("Wrong username");
    }

    //On sign up
    public void createAccount(User user){
        Database.put(user.getUserName(),user.getPassword());
        save(Database);
    }

    public void save(HashMap<String, String> hashmap) {
        String filename="C:\\Users\\bo2dy\\OneDrive\\Desktop\\HCI\\milestone 1\\HCIBackend\\authentication file\\users";
        try (FileOutputStream fileOut = new FileOutputStream(filename);
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            objectOut.writeObject(hashmap);
            System.out.println("HashMap successfully written to " + filename);
        } catch (IOException e) {
            System.err.println("Error writing HashMap to " + filename + ": " + e.getMessage());
        }
    }

    //put constraint on the password before approving
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


}
