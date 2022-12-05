package org.tse.TD1;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Collection;

import org.hamcrest.collection.IsCollectionWithSize;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.test.web.servlet.MockMvc;
import org.tse.TD1.ServiceImplementation.DeveloperService;
import org.tse.TD1.ServiceImplementation.TaskService;
import org.tse.TD1.domain.Task;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@ActiveProfiles(profiles = "test")
public class TaskControllerTest {
    @Autowired
    MockMvc mvc;
    @Autowired
    private TaskService taskService;
    @Autowired
    private DeveloperService developerService;
    @Test
    public void testtask() throws Exception {

        mvc.perform(get("/tasks")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].title", is("first_task")))
                .andExpect(jsonPath("$[0].developerSet[0].firstname", is("ihsane")))
                .andExpect(jsonPath("$[0].nbrhourreel", is(12)));


    }

    @Test
    public void testtaskpost() throws Exception {
        Task task = new Task();
        task.setTitle("tasktest");
        mvc.perform(post("/tasks")
                        .content(new ObjectMapper().writeValueAsString(task))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("title", is("tasktest")));


    }

    @Test
    public void testtaskmove() throws Exception {
        LeftOrRight direction = new LeftOrRight();
        direction.setTitle("right");
        mvc.perform(patch("/tasks/1")
                        .content(new ObjectMapper().writeValueAsString(direction))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("title", is("first_task")))
                .andExpect(jsonPath("taskStatus.label", is("En train ")));


    }


    class LeftOrRight{
        public String title;

        public void setTitle(String title) {
            this.title = title;
        }
    }




}
