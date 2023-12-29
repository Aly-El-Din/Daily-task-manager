package com.example.HCIBackend;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;

@RestController
public class TaskManagerController {

    Authentication authentication;
    TaskManagerService taskManagerService;
    TaskManagerDto taskManagerDto;

    @Autowired
    public TaskManagerController(Authentication authentication, TaskManagerService taskManagerService,
                                 TaskManagerDto taskManagerDto) {
        this.authentication = authentication;
        this.taskManagerService = taskManagerService;
        this.taskManagerDto = taskManagerDto;
    }




    @PostMapping("/signup")
    public String signUp(@RequestBody User user) {
        try {
            if (authentication.isPasswordValid(user.getPassword())) {
                authentication.createAccount(user);
                return "Welcome";
            }
        } catch (Exception e){
            return e.getMessage();
        }
        return null;
    }

    @GetMapping("/load")
    public HashMap<String,String> getMap(){
        return taskManagerService.load();
    }


    @PostMapping("/newTask/normal")
    public DatedTask createTask(@RequestBody DatedTask task){

        return  task;
    }

    //login endpoint

    @PostMapping("/login")
    public String login(@RequestBody User user){
        try {
    return authentication.validate(user);
        }
        catch (Exception e){
            return e.getMessage();
        }
    }





}
