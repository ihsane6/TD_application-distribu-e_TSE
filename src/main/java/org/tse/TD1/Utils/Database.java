package org.tse.TD1.Utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.tse.TD1.ServiceImplementation.DeveloperService;
import org.tse.TD1.dao.DeveloperRepo;
import org.tse.TD1.dao.TaskRepo;
import org.tse.TD1.dao.TaskStatusRepo;
import org.tse.TD1.domain.Developer;
import org.tse.TD1.domain.TaskStatus;


@Component
public class Database implements CommandLineRunner {
    @Autowired
    TaskStatusRepo taskStatusRepo;
    @Autowired
    DeveloperRepo developerRepo;



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

        Developer developer1 = new Developer();
        developer1.setFirstname("ali");
        developer1.setEmail("ali@1s45.com");
        developer1.setLastname("lsks");
        developer1.setPassword("hddkd14");
        developerRepo.save(developer1);



    }
}
