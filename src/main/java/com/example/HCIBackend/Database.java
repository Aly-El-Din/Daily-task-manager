package com.example.HCIBackend;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.*;

@Component
// singleton class
public class Database {

    private static Database database;


    private HashMap<String, User> data;

    @Autowired
    public Database() {
        this.data=new HashMap<>();
    }

    public static Database getInstance(){
        if(database ==null){
        database = new Database();
        }
        return database;
    }



    public HashMap<String,User> getDatabase() {
        return this.data;
    }

    public void setDatabase(HashMap<String, User> database) {
        this.data = database;
    }

    // Save Database into data.json
    public void save() {
        String filename = "C:\\Users\\bo2dy\\OneDrive\\Desktop\\HCI\\milestone 1\\HCIBackend\\Database file\\temp.json";
        LinkedList<User> users = new LinkedList<>();

        try (FileWriter fileWriter = new FileWriter(filename)) {
            for (Map.Entry<String, User> entry : data.entrySet()) {
                users.add(entry.getValue());
            }
            // Create ObjectMapper
            ObjectMapper objectMapper = new ObjectMapper();
            // Write LinkedList to JSON file
            String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(users);
            fileWriter.write(json);
            fileWriter.flush();
            System.out.println("HashMap successfully written to " + filename);
        } catch (IOException e) {
            System.err.println("Error writing HashMap to " + filename + ": " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void load() {
    String filename = "C:\\Users\\bo2dy\\OneDrive\\Desktop\\HCI\\milestone 1\\HCIBackend\\Database file\\temp.json";
    try {
        // Create ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();

        // Read the JSON file into a List<User>
        List<User> usersList = objectMapper.readValue(new File(filename), new TypeReference<>() {});

        data.clear();
        // Populate the HashMap with the loaded data
        for (User user : usersList) {
            data.put(user.getUserName(), user);
        }
        System.out.println("HashMap successfully loaded from " + filename);
    } catch (IOException e) {
        System.err.println("Error loading HashMap from " + filename + ": " + e.getMessage());
        e.printStackTrace();
    }




    }
}
