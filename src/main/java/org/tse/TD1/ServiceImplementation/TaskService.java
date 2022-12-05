package org.tse.TD1.ServiceImplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.tse.TD1.dao.TaskRepo;
import org.tse.TD1.dao.TaskStatusRepo;
import org.tse.TD1.domain.Task;
import org.tse.TD1.domain.TaskStatus;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Component
public class TaskService implements org.tse.TD1.ServiceInterface.TaskService {
    @Autowired
    TaskRepo taskRepo;
    @Autowired
    TaskStatusRepo taskStatusRepo;

    @Override
    public Collection<Task> findAllTasks() {
        List<Task> tasklist = taskRepo.findAll();
        return tasklist;
    }

    @Override
    public Task findTask(Long id) {

        Task task = taskRepo.findById(id).orElse(null);
        return task;

    }

    @Override
    public Task moveRightTask(Task task) {
        TaskStatus taskStatus = task.getTaskStatus();
        if (taskStatus.getId() == 1L) {
            task.setTaskStatus(taskStatusRepo.findById(2L).orElse(null));
        } else if (taskStatus.getId() == 2L) {
            task.setTaskStatus(taskStatusRepo.findById(3L).orElse(null));

        } else {
        }
        return task;

    }

    @Override
    public Task moveLeftTask(Task task) {
        TaskStatus taskStatus = task.getTaskStatus();
        if (taskStatus.getId() == 3L) {
            task.setTaskStatus(taskStatusRepo.findById(2L).orElse(null));
        } else if (taskStatus.getId() == 2L) {
            task.setTaskStatus(taskStatusRepo.findById(1L).orElse(null));

        } else {
        }
        return task;


    }
}
