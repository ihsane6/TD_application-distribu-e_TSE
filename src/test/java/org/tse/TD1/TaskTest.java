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

import org.tse.TD1.dao.DeveloperRepo;
import org.tse.TD1.dao.TaskRepo;
import org.tse.TD1.domain.Developer;
import org.tse.TD1.domain.Task;

import java.util.List;


@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles(profiles = "test")
class TaskTest {

    @Autowired
    DeveloperRepo developerRepo;
    @Autowired
    TaskRepo taskRepo;
    @Test
    void testAddDevelopers() {
        Developer developer = new Developer();
        Task task = new Task();
        task.addevelopper(developer);
        Assert.assertEquals(1, task.getDeveloperSet().size());

    }

    @Test
    void testFindAllDevelopers() {
        List<Developer> devList = developerRepo.findAll();
        Assert.assertEquals(1, devList.size());



    }
    @Test
    void testFindAllTasks() {
        List<Task> tasksList = taskRepo.findAll();
        Assert.assertEquals(1, tasksList.size());
        Task task1 = new Task();
        task1.setId(2L);
        Task task2 = taskRepo.save(task1);
        Assert.assertEquals(2L, (long)task2.getId());
    }

}
