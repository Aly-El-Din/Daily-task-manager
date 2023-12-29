package com.example.HCIBackend;

 public interface ITask {

     String getTaskName();
     void setTaskName(String taskName);
     String getTaskDescription();
     void setTaskDescription(String taskDescription);
     boolean isPriority();
     void setPriority(boolean priority);
     boolean isDone();
     void setDone(boolean done);

 }
