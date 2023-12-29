package com.example.HCIBackend;

 interface ITask {
      String taskDescription="";
      String priority="";
      boolean done=false;

     String getTaskDescription();
     void setTaskDescription(String taskDescription);
     String getPriority();
     void setPriority(String priority);
     boolean isDone();
     void setDone(boolean done);

 }
