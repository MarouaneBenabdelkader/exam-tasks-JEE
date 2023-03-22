package com.example.examtasks.buisiness;

import com.example.examtasks.models.Task;

import java.util.List;

public interface Service {
    Task addTask(Task task);
    Task getById(Integer id);
    List<Task> loadTasks();
    boolean modifyTask(Task task1, Task task2,String typeofswap);
    Task removeTask(Task task);
}
