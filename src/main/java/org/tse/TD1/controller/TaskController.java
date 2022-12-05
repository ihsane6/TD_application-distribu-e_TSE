package org.tse.TD1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tse.TD1.ServiceImplementation.TaskService;
import org.tse.TD1.domain.Task;
import org.tse.TD1.domain.TaskStatus;

import javax.websocket.server.PathParam;
import java.util.Collection;
import java.util.List;

@RestController
public class TaskController {
    @Autowired
    TaskService taskService;

    @GetMapping( "/tasks")
    public Collection<Task> getTask() {
        return taskService.findAllTasks();

    }

    @PostMapping("/tasks")
    public Task addTask(@RequestBody Task task){
        return taskService.addTask(task);
    }

    @PatchMapping("tasks/{id}")
    public Task moveTask0(@PathVariable Long id,@RequestBody LeftOrRight direction){
        if (direction.title.toLowerCase().equals("right")){
            return taskService.moveRightTask(taskService.findTask(id));
        }
        else if (direction.title.toLowerCase().equals("left")){
            return taskService.moveLeftTask(taskService.findTask(id));
        }

        return null;
    }
}

class LeftOrRight{
    public String title;

    public void setTitle(String title) {
        this.title = title;
    }
}
