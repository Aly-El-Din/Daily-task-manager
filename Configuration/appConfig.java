package com.example.demo.Configuration;

import com.example.demo.Model.User;
import com.example.demo.Model.WorkTask;
import com.example.demo.Service.Authentication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.HashMap;

@Configuration
public class appConfig {
    @Bean
    public String string() {
        return new String();
    }
    @Bean
    public Boolean bool() {
        return false;
    }
    @Bean
    public Authentication authentication() {
        return new Authentication();
    }
    @Bean
    LocalDate localDate(){
      return null;
    }
    @Bean
    public WorkTask workTask(){
        return new WorkTask();
    }
    @Bean
    public User user(){
        return new User("","");
    }
    @Bean
    public HashMap<String,User> hashMap(){
        return  new HashMap<>();
    }
}

