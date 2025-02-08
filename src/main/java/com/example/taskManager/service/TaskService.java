package com.example.taskManager.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.taskManager.model.Task;
import com.example.taskManager.repository.TaskRepository;

@Service
public class TaskService extends BaseServiceImpl<Task> {
    TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        super(taskRepository);
        this.taskRepository = taskRepository;
    }

    public Iterable<Task> findAll() {
        return taskRepository.findAll();
    }

    public Optional<Task> findById(String id) {
        return taskRepository.findById(id);
    }

    public Task save(Task entity) {
        System.out.println("Debugin save fn");
        return taskRepository.save(entity);
    }

    public Task update(Task entity) {
        return taskRepository.save(entity);
    }

}
