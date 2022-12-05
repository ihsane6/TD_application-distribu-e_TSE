package org.tse.TD1;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.runner.RunWith;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import org.tse.TD1.ServiceImplementation.DeveloperService;
import org.tse.TD1.ServiceImplementation.TaskService;
import org.tse.TD1.dao.DeveloperRepo;
import org.tse.TD1.dao.TaskRepo;
import org.tse.TD1.dao.TaskStatusRepo;
import org.tse.TD1.domain.Developer;
import org.tse.TD1.domain.Task;
import org.tse.TD1.domain.TaskStatus;

import java.util.List;


@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles(profiles = "test")
class UnitTestService {

    @Autowired
    DeveloperService developerService;

    @Test
    void testAllDevelopers() {
        Assert.assertEquals(1, developerService.findAllDevelopers().size());
    }
    @Autowired
    TaskService taskService;

    @Test
    void testTask() {
        Assert.assertEquals(1, taskService.findAllTasks().size());

    }
    @Test
    void testFindTask() {
        Assert.assertEquals("task", taskService.findTask(1L).getTitle());

    }
    @Autowired
    TaskStatusRepo taskStatusRepo;

    @Test
    void MoveRighttest() {
        Task tasktest = new Task();
        TaskStatus taskStatus = taskStatusRepo.findById(2L).orElse(null);
        tasktest.setTaskStatus(taskStatus);
        TaskStatus expectedStatus = taskStatusRepo.findById(3L).orElse(null);

        Assert.assertEquals(expectedStatus, taskService.moveRightTask(tasktest).getTaskStatus());

    }

    @Test
    void MoveLefttest(){
        Task tasktest = new Task();
        TaskStatus taskStatus = taskStatusRepo.findById(3L).orElse(null);
        tasktest.setTaskStatus(taskStatus);
        TaskStatus expectedStatus = taskStatusRepo.findById(2L).orElse(null);

        Assert.assertEquals(expectedStatus, taskService.moveLeftTask(tasktest).getTaskStatus());
    }

}
