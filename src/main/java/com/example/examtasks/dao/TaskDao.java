package com.example.examtasks.dao;

import com.example.examtasks.models.Task;

import java.util.List;

public interface TaskDao {
    Task save(Task task);
    Task findById(Integer id);
    List<Task> getAllTasks();
    boolean update(Task task1, Task task2 ,String typeofswap);
    Task delete(Task task);

}
