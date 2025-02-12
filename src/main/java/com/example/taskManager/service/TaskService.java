package com.example.taskManager.service;

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

    public Task save(Task entity) {
        return taskRepository.save(entity);
    }

}
