package com.example.HCIBackend;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Date;

@Component
 public class DatedTask implements ITask {
     private String taskDescription;
     private String priority;
     private boolean done;

     // yet to be adjusted

//     private LocalDate assignedDated;
//     private LocalDate dueDate;
//     private LocalDate startDate;
//     private LocalDate endDate;


    public DatedTask(String taskDescription, String priority, boolean done) {
        this.taskDescription = taskDescription;
        this.priority = priority;
        this.done = done;
    }

    @Override
    public String getTaskDescription() {
        return null;
    }
    @Override
    public void setTaskDescription(String taskDescription) {

    }
    @Override
    public String getPriority() {
        return null;
    }
    @Override
    public void setPriority(String priority) {

    }
    @Override
    public boolean isDone() {
        return false;
    }
    @Override
    public void setDone(boolean done) {
        this.done=done;
    }

//     public LocalDate getAssignedDated() {
//         return assignedDated;
//     }
//
//     public void setAssignedDated(LocalDate assignedDated) {
//         this.assignedDated = assignedDated;
//     }
//
//     public LocalDate getDueDate() {
//         return dueDate;
//     }
//
//     public void setDueDate(LocalDate dueDate) {
//         this.dueDate = dueDate;
//     }
//
//     public LocalDate getStartDate() {
//         return startDate;
//     }
//
//     public void setStartDate(LocalDate startDate) {
//         this.startDate = startDate;
//     }
//
//     public LocalDate getEndDate() {
//         return endDate;
//     }
//
//     public void setEndDate(LocalDate endDate) {
//         this.endDate = endDate;
//     }
 }
