package com.example.taskManager.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public class BaseServiceImpl<T> implements IBaseService<T> {

    JpaRepository<T, String> repository;

    @Autowired
    public BaseServiceImpl(JpaRepository<T, String> repository) {
        this.repository = repository;
    }

    public Iterable<T> findAll() {
        return repository.findAll();
    }

    public Optional<T> findById(String id) {
        return repository.findById(id);
    }

    public T save(T entity) {
        return repository.save(entity);
    }

    public T update(T entity) {
        return repository.save(entity);
    }

    public void delete(String id) {
        Optional<T> entity = this.findById(id);
        if (entity.isPresent()) {
            repository.delete(entity.get());
        }
    }
}
