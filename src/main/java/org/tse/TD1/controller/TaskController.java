package org.tse.TD1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tse.TD1.ServiceImplementation.TaskService;
import org.tse.TD1.domain.Task;
import org.tse.TD1.domain.TaskStatus;

import java.util.Collection;
import java.util.List;

@RestController
public class TaskController {
    @Autowired
    TaskService taskService;

    @GetMapping( "/tasks")
    public Collection<Task> gettask() {
        return taskService.findAllTasks();

    }





}
