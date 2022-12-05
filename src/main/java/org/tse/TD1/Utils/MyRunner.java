package org.tse.TD1.Utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.tse.TD1.dao.*;
import org.tse.TD1.domain.*;

import java.time.LocalDate;


@Component
@Profile("test")
@Slf4j
public class MyRunner implements CommandLineRunner {
    @Autowired
    DeveloperRepo developerRepo;
    @Autowired
    ChangeLogRepo changeLogRepo;

    @Autowired
    TaskStatusRepo taskStatusRepo;
    @Autowired
    TaskTypeRepo taskTypeRepo;
    @Autowired
    TaskRepo taskRepo;

    @Override
    public void run(String... args) throws Exception {
        TaskStatus taskStatus1 = new TaskStatus();
        TaskStatus taskStatus2 = new TaskStatus();
        TaskStatus taskStatus3 = new TaskStatus();
        taskStatus1.setId(1L);
        taskStatus2.setId(2L);
        taskStatus3.setId(3L);
        taskStatus1.setLabel("à faire");
        taskStatus2.setLabel("En train ");
        taskStatus3.setLabel("complet");

        taskStatusRepo.save(taskStatus1);
        taskStatusRepo.save(taskStatus2);
        taskStatusRepo.save(taskStatus3);
        Developer developer = new Developer();
        developer.setFirstname("ihsane");
        developer.setEmail("ihsane.1@gmail.fr");
        developer.setLastname("EL ");
        developer.setPassword("haisjzk");
        developer.setStartcontract(LocalDate.now());
        ChangeLog changeLog = new ChangeLog();
        TaskType taskType = new TaskType();
        taskType.setLabel("STRING");
        Task task = new Task();
        task.setId(1L);
        task.setTitle("first_task");
        task.setNbrhourreel(12);
        task.setNbrhoursforcas(24);
        task.setCreated(LocalDate.now());
        task.setTaskStatus(taskStatus1);
        task.setTaskType(taskType);
        task.addevelopper(developer);
        changeLog.setTask(task);
        changeLog.setSourceStatus(taskStatus1);
        changeLog.setTargetStatus(taskStatus1);
        changeLog.setOccured(LocalDate.now());
        developerRepo.save(developer);
        taskTypeRepo.save(taskType);
        taskRepo.save(task);


















    }
}
