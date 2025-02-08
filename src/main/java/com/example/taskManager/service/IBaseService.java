package com.example.taskManager.service;

import java.util.Optional;

public interface IBaseService<T> {
    public Iterable<T> findAll();

    public Optional<T> findById(String id);

    public T save(T entity);

    public T update(T entity);

    public void delete(String id);
}
