package com.example.HCIBackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedList;

@Component
public class TaskManagerDto {

    LinkedList<ITask> toDOList;

    @Autowired
    public TaskManagerDto(LinkedList<ITask> toDOList) {
        this.toDOList = toDOList;
    }
}
