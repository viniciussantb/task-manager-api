package com.example.taskManager.controller;

import com.example.taskManager.model.Task;
import com.example.taskManager.service.TaskService;

import org.junit.jupiter.api.*;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.Optional;

@WebMvcTest(controllers = { TaskController.class })
public class TaskControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private TaskService taskService;

    Task task;

    @BeforeEach
    void setUp() {
        task = new Task();
        task.setId(1);
        task.setTitle("Task");
    }

    @Test
    public void testGetTasks() throws Exception {
        Iterable<Task> tasks = new ArrayList<>();
        Mockito.when(this.taskService.findAll()).thenReturn(tasks);

        this.mvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(this.taskService, Mockito.times(1)).findAll();
    }

    @Test
    public void testGetTask() throws Exception {
        Optional<Task> task = Optional.ofNullable(new Task());
        task.get().setId(1);
        task.get().setTitle("Testing Get Task");
        Mockito.when(this.taskService.findById("1")).thenReturn(task);

        this.mvc.perform(MockMvcRequestBuilders.get("/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value("1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.title").value("Testing Get Task"));
        Mockito.verify(this.taskService, Mockito.times(1)).findById("1");
    }

    @Test
    public void testDeleteTask() throws Exception {
        Optional<Task> task = Optional.ofNullable(new Task());
        task.get().setId(1);
        task.get().setTitle("Testing Get Task");

        this.mvc.perform(MockMvcRequestBuilders.delete("/1"))
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(this.taskService, Mockito.times(1)).delete("1");
    }

}
