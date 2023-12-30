package com.example.HCIBackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.*;

@Component
public class User {

    private String userName;
    private String password;
    //private LinkedList<DailyTasks> dailyTasks=new LinkedList<>();

    @Autowired
    private HashMap<String,LinkedList<WorkTask>> tasks ;


    public User(){
    }

    @Autowired
    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
        this.tasks=new HashMap<>();
    }

    public void setWorkTasks(WorkTask workTask) {

        if (this.tasks == null) {
            this.tasks = new HashMap<>();
            this.tasks.put(" ", new LinkedList<>());
        }

        if( this.tasks.get(workTask.getDate()) == null ){
            this.tasks.put(workTask.getDate(),new LinkedList<>(List.of(workTask)));
            this.tasks.remove(" ");
        }

       else this.tasks.get(workTask.getDate()).add(workTask);
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

    public LinkedList<WorkTask> getTask(String date){
        return this.tasks.get(date);
    }

    public Map<String, LinkedList<WorkTask>> getTasks() {
        return this.tasks;
    }

    public void setTasks(HashMap<String, LinkedList<WorkTask>> tasks) {
        this.tasks = tasks;
    }
}
