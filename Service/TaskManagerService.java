package com.example.demo.Service;


import com.example.demo.Model.User;
import com.example.demo.Model.WorkTask;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedList;


@Service
public class TaskManagerService {
    private Database database;

    public TaskManagerService()
    {
        this.database = Database.getInstance();
    }

    //create a work task
    public void createWorkTask(WorkTask workTask, String user){
        //put task in database in linked list of tasks for each user
        if(database.getDatabase().get(user)==null){
            return;
        }
        database.getDatabase().get(user).setWorkTasks(workTask);

        database.save();


    }

    public LinkedList<WorkTask> getTasksByDate(String username, String date){
        return database.getDatabase().get(username).getTask(date);
    }

    public LinkedList<WorkTask> deleteTask(String taskId,String date, String username) {
        User user = database.getDatabase().get(username);

        // Check if the user and tasks map exist
        if (user != null && user.getTasks() != null) {
            // Get the LinkedList of tasks for the given date
            LinkedList<WorkTask> tasksForDate = user.getTasks().get(date);

            // Check if the LinkedList for the date exists
            if (tasksForDate != null) {
                // Find and update the task with the given taskId
                for (int i=0;i<tasksForDate.size();i++) {
                    if (tasksForDate.get(i).getId().equals(taskId)) {
                        tasksForDate.remove(i);
                    }
                }
            }
        }
        database.save();
        return user.getTask(date);
    }
    public LinkedList<WorkTask> editTask(String username, WorkTask newWorkTask) {
        // Get the user
        User user = database.getDatabase().get(username);

        // Check if the user and tasks map exist
        if (user != null && user.getTasks() != null) {
            // Get the LinkedList of tasks for the given date
            LinkedList<WorkTask> tasksForDate = user.getTasks().get(newWorkTask.getDate());

            // Check if the LinkedList for the date exists
            if (tasksForDate != null) {
                // Find and update the task with the given taskId
                for (WorkTask existingTask : tasksForDate) {
                    if (existingTask.getId().equals(newWorkTask.getId())) {
                        // Update task details
                        existingTask.setTaskName(newWorkTask.getTaskName());
                        existingTask.setTaskDescription(newWorkTask.getTaskDescription());
                        existingTask.setDate(newWorkTask.getDate());
                        existingTask.setDone(newWorkTask.isDone());
                        // Save changes
                        database.save();
                        return tasksForDate;
                    }
                }
            }
        }
        database.save();
        return user.getTask(newWorkTask.getDate());
    }
    public LinkedList<WorkTask>addRoutines(WorkTask routine,String username){
        User user = database.getDatabase().get(username);
        if (user != null && user.getRoutines() != null) {
            user.setRoutines(routine);
        }
        database.save();
        return user.getRoutines();
    }
    public LinkedList<WorkTask>getRoutines(WorkTask routine,String username){
        User user = database.getDatabase().get(username);
        return user.getRoutines();
    }


}