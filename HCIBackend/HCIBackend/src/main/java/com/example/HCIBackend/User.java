package com.example.HCIBackend;

import org.springframework.stereotype.Component;

import java.util.LinkedList;

@Component
public class User {

    private String userName;
    private String password;
    private LinkedList<Task> task;
    private LinkedList<DatedTask> datedTasks;

    public User(String userName, String password, LinkedList<Task> task
            , LinkedList<DatedTask> datedTasks) {
        this.userName = userName;
        this.password = password;
        this.task = task;
        this.datedTasks = datedTasks;
    }


    public LinkedList<Task> getTask() {
        return task;
    }

    public void setTask(LinkedList<Task> task) {
        this.task = task;
    }

    public LinkedList<DatedTask> getDatedTasks() {
        return datedTasks;
    }

    public void setDatedTasks(LinkedList<DatedTask> datedTasks) {
        this.datedTasks = datedTasks;
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
}
