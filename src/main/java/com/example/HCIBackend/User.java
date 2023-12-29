package com.example.HCIBackend;

import org.springframework.stereotype.Component;

import java.util.LinkedList;

@Component
public class User {

    private String userName;
    private String password;
    //private LinkedList<DailyTasks> dailyTasks=new LinkedList<>();
    private LinkedList<WorkTask> workTasks=new LinkedList<>();

    public User(){}

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }


    //public LinkedList<DailyTasks> getDailyTasks() {
      //  return dailyTasks;
    //}

    //public void setDailyTasks(DailyTasks dailyTask) {
      //  this.dailyTasks.add(dailyTask);
    //}

    public LinkedList<WorkTask> getWorkTasks() {
        return workTasks;
    }

    public void setWorkTasks(WorkTask workTask) {
        this.workTasks.add(workTask);
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
