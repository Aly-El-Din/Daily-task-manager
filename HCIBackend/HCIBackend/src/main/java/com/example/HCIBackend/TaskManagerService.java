package com.example.HCIBackend;

import java.io.*;
import org.springframework.stereotype.Service;

import java.util.HashMap;
@Service
public class TaskManagerService {

    public TaskManagerService() {}

    public  HashMap<String, String> load() {
        String filename="C:\\Users\\bo2dy\\OneDrive\\Desktop\\HCI\\milestone 1\\HCIBackend\\authentication file\\users";
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
        return hashmap;
    }

}
