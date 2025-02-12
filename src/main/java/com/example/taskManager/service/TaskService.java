package com.example.taskManager.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.taskManager.model.Task;
import com.example.taskManager.repository.TaskRepository;

import java.util.Date;
import java.util.TimeZone;
import java.util.Calendar;

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
        return taskRepository.save(entity);
    }

}
