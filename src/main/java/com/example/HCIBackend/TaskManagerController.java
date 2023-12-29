package com.example.HCIBackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@CrossOrigin

public class TaskManagerController {

    Authentication authentication;
    TaskManagerService taskManagerService;
    TaskManagerDto taskManagerDto;


    @Autowired
    public TaskManagerController(Authentication authentication,
                                 TaskManagerService taskManagerService, TaskManagerDto taskManagerDto) {
        this.authentication = authentication;
        this.taskManagerService = taskManagerService;
        this.taskManagerDto = taskManagerDto;
    }

    //sign up and register a new user
    @PostMapping("/signup")
    public String signUp(@RequestBody User user) {
        try {
            if (authentication.isUsernameValid(user.getUserName()) && authentication.isPasswordValid(user.getPassword())) {
                authentication.createAccount(user);
                taskManagerDto.getDatabase().put(user.getUserName(),user);
                System.out.println(taskManagerDto.getDatabase().get(user.getUserName()).getUserName());
               // taskManagerDto.save();
                return "Welcome";
            }
        } catch (Exception e){
            return e.getMessage();
        }
        return null;
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


    //create a new work task
    @PostMapping("/create/workTask")
    public WorkTask createTask(@RequestBody WorkTask task, @RequestHeader("user") String user)
    {
        taskManagerDto.load();
        taskManagerService.createWorkTask(task,user);
        taskManagerDto.save();
        return  task;
    }

    //load database from data.json

    @GetMapping("/loadDB")
    public HashMap<String,User> loadDB(){
       taskManagerDto.load();
        return taskManagerDto.getDatabase();
    }


    //load info of a given user
    @GetMapping("/dashboard/{username}")
    public User loadInfo(@PathVariable String username){
        taskManagerDto.load();
        return taskManagerDto.getDatabase().get(username);
    }


    @GetMapping("/save")
    public void save(){
        taskManagerDto.save();
    }

    @GetMapping("/getdb")
    public HashMap<String,User> printDB(){
        return taskManagerDto.getDatabase();
    }

    @GetMapping("/data")
    public LinkedList<WorkTask>tasksByDate(@RequestParam String username,@RequestParam String date){
        return taskManagerService.getTasksByDate(username,date);
    }

    @DeleteMapping("/delete")public LinkedList<WorkTask> deleteTask(@RequestParam String username,@RequestParam int id)
    {
        return taskManagerService.deleteTask(id,username);
    }





}
