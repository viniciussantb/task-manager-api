package com.example.taskManager.service;

import com.example.taskManager.model.Task;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BaseServiceImplTest {

    @Mock
    private JpaRepository<Task, String> repository;

    @InjectMocks
    private BaseServiceImpl<Task> baseService;

    private Task task;

    @BeforeEach
    public void setUp() {
        task = new Task();
        task.setId(1);
        task.setTitle("Test Task");
    }

    @Test
    public void testFindAll() {
        List<Task> tasks = mock(List.class);
        when(repository.findAll()).thenReturn(tasks);

        Iterable<Task> result = baseService.findAll();

        assertNotNull(result);
        verify(repository, times(1)).findAll();
    }

    @Test
    public void testFindById() {
        when(repository.findById("1")).thenReturn(Optional.of(task));

        Optional<Task> result = baseService.findById("1");

        assertTrue(result.isPresent());
        assertEquals(task, result.get());
        verify(repository, times(1)).findById("1");
    }

    @Test
    public void testSave() {
        when(repository.save(task)).thenReturn(task);

        Task result = baseService.save(task);

        assertNotNull(result);
        assertEquals(task, result);
        verify(repository, times(1)).save(task);
    }

    @Test
    public void testUpdate() {
        when(repository.save(task)).thenReturn(task);

        Task result = baseService.update(task);

        assertNotNull(result);
        assertEquals(task, result);
        verify(repository, times(1)).save(task);
    }

    @Test
    public void testDelete() {
        when(repository.findById("1")).thenReturn(Optional.of(task));
        doNothing().when(repository).delete(task);

        baseService.delete("1");

        verify(repository, times(1)).findById("1");
        verify(repository, times(1)).delete(task);
    }

    @Test
    public void testDeleteWhenEntityNotFound() {
        when(repository.findById("1")).thenReturn(Optional.empty());

        baseService.delete("1");

        verify(repository, times(1)).findById("1");
        verify(repository, times(0)).delete(task);
    }
}
