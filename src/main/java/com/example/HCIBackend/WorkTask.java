package com.example.HCIBackend;
import org.springframework.beans.factory.annotation.Autowired;import org.springframework.stereotype.Component;
import java.util.Calendar;
import java.util.GregorianCalendar;
@Component public class WorkTask implements ITask {
    private String taskName;
    private String taskDescription;
    //modified by aly
    private String date;
    private boolean priority;
    //date
    private int id;
    private boolean done;
    // Dates yet to be adjusted  hint: use Calendar class



    @Autowired
    public WorkTask(String taskName, String taskDescription, boolean priority, boolean done,int id) {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.priority = priority;
        this.done = done;
        this.id=id;
    }
    public WorkTask(){}


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
        this.taskDescription=taskDescription;
    }
    public boolean isPriority() {
        return this.priority;
    }
    public void setPriority(boolean priority) {
        this.priority=priority;
    }
    public boolean isDone() {
        return this.done;    }
    public void setDone(boolean done) {this.done=done;}

    public void setDate(String date){this.date=date;}
    public String getDate(){return this.date;}

    public void setId(int id) {this.id = id;}
    public int getId() {return id;}}