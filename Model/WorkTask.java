package com.example.demo.Model;

import com.example.demo.Model.ITask;
import org.springframework.beans.factory.annotation.Autowired;import org.springframework.stereotype.Component;
import java.util.Calendar;
import java.util.GregorianCalendar;

@Component
public class WorkTask implements ITask {

    private String taskName;
    private String taskDescription;
    //modified by aly
    private String date;

    private String id;
    private String priority;
    private boolean done;


    // Dates yet to be adjusted  hint: use Calendar class
    @Autowired
    public WorkTask(String taskName, String taskDescription, String priority, boolean done,String date,String id) {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.priority = priority;
        this.done = done;
        this.date=date;
        this.id=id;
    }

    public WorkTask() {
    }


    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }


    public String getTaskDescription() {
        return this.taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }


    public String getPriority() {
        return this.priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }


    public boolean isDone() {
        return this.done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }


    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return this.date;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getId() {
        return id;
    }
}