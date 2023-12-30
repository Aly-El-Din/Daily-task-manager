package com.example.demo.Model;

 public interface ITask {

     String getTaskName();
     void setTaskName(String taskName);
     String getTaskDescription();
     void setTaskDescription(String taskDescription);
     String getPriority();
     void setPriority(String priority);
     boolean isDone();
     void setDone(boolean done);

 }
