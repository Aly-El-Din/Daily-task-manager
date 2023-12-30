
package com.example.HCIBackend;


import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedList;


@Service
public class TaskManagerService {

    private Database database;

    public TaskManagerService ()
    {
        this.database = Database.getInstance();
    }

    //create a work task
    public void createWorkTask(WorkTask workTask, String user){
        //put task in database in linked list of tasks for each user

       database.getDatabase().get(user).setWorkTasks(workTask);
       database.save();
    }

    public LinkedList<WorkTask> getTasksByDate(String username, String date){
        return database.getDatabase().get(username).getTask(date);
    }

    public LinkedList<WorkTask> deleteTask(String date, String username) {
        // Null check
        if (database == null || !database.getDatabase().containsKey(username)) {
            // Handle the case where the user or database is not found
            return new LinkedList<>();
        }
        LinkedList<WorkTask> workTasks = database.getDatabase().get(username).getTask(date);
        int index=0;
        for(WorkTask workTask : workTasks){
            index++;
            if(workTask.getDate().equalsIgnoreCase(date)){
                workTasks.remove(index);
                return workTasks;
            }
        }
        return new LinkedList<>();
    }
}
