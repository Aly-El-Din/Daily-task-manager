package com.example.HCIBackend;

import org.springframework.stereotype.Component;

@Component
 public class Task implements ITask{
    private String taskDescription;
    private String priority;
    private boolean done;

    public Task(String taskDescription, String priority, boolean done) {
        this.taskDescription = taskDescription;
        this.priority = priority;
        this.done = done;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
