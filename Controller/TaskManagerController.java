package com.example.demo.Controller;


import com.example.demo.Model.User;
import com.example.demo.Model.WorkTask;
import com.example.demo.Service.Authentication;
import com.example.demo.Service.Database;
import com.example.demo.Service.TaskManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@CrossOrigin

public class TaskManagerController {

    Authentication authentication;
    TaskManagerService taskManagerService;
    Database database;


    @Autowired
    public TaskManagerController(Authentication authentication,
                                 TaskManagerService taskManagerService) {
        this.authentication = authentication;
        this.taskManagerService = taskManagerService;
        this.database = Database.getInstance();
    }

    //sign up and register a new user
    @PostMapping("/signup")
    public String signUp(@RequestBody User user) {

        return authentication.createAccount(user);
    }
    //login a registered user
    @PostMapping("/login")
    public String login(@RequestBody User user){
        try {
            return authentication.validate(user);
        }
        catch (Exception e){

            return e.getMessage();
        }
    }


    @GetMapping("/load")
    public HashMap<String,String> getMap(){
        return authentication.load();
    }

    @PutMapping("/edit/workTask/{user}")
    public void editTask(@PathVariable String user,@RequestBody WorkTask newTask,@PathVariable String pastDate){
        taskManagerService.editTask(user,newTask);
    }
    //create a new work task
    @PostMapping("/create/workTask/{user}")
    public WorkTask createTask(@RequestBody WorkTask task, @PathVariable String user)
    {

        taskManagerService.createWorkTask(task,user);

        return  task;
    }

    //load database from data.json
    @GetMapping("/loadDB")
    public HashMap<String,User> loadDB(){
        database.load();
        return database.getDatabase();
    }


    //load info of a given user
    @GetMapping("/dashboard/{username}")
    public User loadInfo(@PathVariable String username){
        database.load();
        return database.getDatabase().get(username);
    }

    @GetMapping("/save")
    public void save(){
        database.save();
    }

    @GetMapping("/getdb")
    public HashMap<String,User> printDB(){
        return database.getDatabase();
    }

    @GetMapping("/data/{username}/{date}")
    public LinkedList<WorkTask>tasksByDate(@PathVariable String username,@PathVariable String date){
        return taskManagerService.getTasksByDate(username,date);
    }

    @DeleteMapping("/delete/{username}/{date}/{id}")public LinkedList<WorkTask> deleteTask(@PathVariable String username
                                                                        ,@PathVariable String date
                                                                        ,@PathVariable String id)
    {
        return taskManagerService.deleteTask(id,date,username);
    }
    @PostMapping("/routine/workTask/{user}")
    public LinkedList<WorkTask> createRoutine(@RequestBody WorkTask task, @PathVariable String user)
    {

        return taskManagerService.addRoutines(task,user);
    }

}