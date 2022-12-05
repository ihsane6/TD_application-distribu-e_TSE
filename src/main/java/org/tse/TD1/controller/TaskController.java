package org.tse.TD1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.tse.TD1.ServiceImplementation.TaskService;
import org.tse.TD1.domain.Task;
import org.tse.TD1.domain.TaskStatus;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TaskController {
    @Autowired
    TaskService taskService;

    @GetMapping( "/tasks")
    public Collection<Task> getTask() {
        return taskService.findAllTasks();

    }

    @PostMapping("/tasks")
    public Task addTask(@Valid @RequestBody Task task){
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

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}

class LeftOrRight{
    public String title;

    public void setTitle(String title) {
        this.title = title;
    }
}
