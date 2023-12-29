package com.example.HCIBackend;


import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;


@Service
public class TaskManagerService {


   private TaskManagerDto taskManagerDto;


    public TaskManagerService(TaskManagerDto taskManagerDto) {
        this.taskManagerDto = taskManagerDto;
    }

    //create a work task
    public void createWorkTask(WorkTask workTask,String user){
        //put task in database in linked list of tasks for each user
       taskManagerDto.getDatabase().get(user).setWorkTasks(workTask);
    }

    public LinkedList<WorkTask> getTasksByDate(String username, String date){
        LinkedList<WorkTask> userWorkTasks=taskManagerDto.getDatabase().get(username).getWorkTasks();
        LinkedList<WorkTask> dateWorkTasks=new LinkedList<>();
        for(WorkTask task:userWorkTasks){
            if(task.getDate().equals(date)) {
                dateWorkTasks.add(task);
            }
        }
        return dateWorkTasks;
    }

    public LinkedList<WorkTask> deleteTask(int id, String username) {

        HashMap<String, User> database = taskManagerDto.getDatabase();
        // Null check
        if (database == null || !database.containsKey(username)) {        // Handle the case where the user or database is not found
            return new LinkedList<>();    }
        LinkedList<WorkTask> workTasks = database.get(username).getWorkTasks();
        // Iterate to find the task with the given ID
        Iterator<WorkTask> iterator = workTasks.iterator();    while (iterator.hasNext()) {
            WorkTask task = iterator.next();
            if (task.getId() == id) {
                iterator.remove(); // Remove the task using the iterator            break; // Assuming IDs are unique, exit the loop after removal
            }    }
        // Return a copy of the modified list
        return new LinkedList<>(workTasks);}

}
