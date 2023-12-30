package com.example.demo.Model;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.LinkedList;

@Component
public class User {
    private String userName;
    private String password;

    private HashMap<String, LinkedList<WorkTask>> tasks;

    private LinkedList<WorkTask>routines;

    public User() {
        this.tasks = new HashMap<>();
        this.routines=new LinkedList<>();
    }

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
        this.tasks = new HashMap<>();
        this.routines=new LinkedList<>();
    }

    //public LinkedList<DailyTasks> getDailyTasks() {
    //  return dailyTasks;
    //}

    //public void setDailyTasks(DailyTasks dailyTask) {
    //  this.dailyTasks.add(dailyTask);
    //}


    public void setWorkTasks(WorkTask workTask) {
        String date = workTask.getDate();
        if (tasks == null) {
            tasks = new HashMap<>();
        }

        // Initialize the LinkedList for the date if it doesn't exist
        tasks.computeIfAbsent(date, k -> new LinkedList<>());

        // Add the work task to the LinkedList
        this.tasks.get(date).add(workTask);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LinkedList<WorkTask> getTask(String date) {
        return this.tasks.get(date);
    }

    public HashMap<String, LinkedList<WorkTask>> getTasks() {
        return tasks;
    }

    public void setTasks(HashMap<String, LinkedList<WorkTask>> tasks) {
        this.tasks = tasks;
    }

    public void setRoutines(WorkTask routine){
        this.routines.add(routine);
    }

    public LinkedList<WorkTask> getRoutines() {
        return routines;
    }

}