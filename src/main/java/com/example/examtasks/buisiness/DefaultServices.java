package com.example.examtasks.buisiness;

import com.example.examtasks.dao.TaskDao;
import com.example.examtasks.dao.TaskDaoMemory;
import com.example.examtasks.models.Task;

import java.util.List;

public class DefaultServices implements Service{
    private static DefaultServices instance = null;
    private TaskDao taskDao;

    private DefaultServices(TaskDao taskDao) {
        this.taskDao = taskDao;
    }

    public static DefaultServices getInstance() {
        if(instance == null){
            instance = new DefaultServices(new TaskDaoMemory());
        }
        return instance;
    }

    @Override
    public Task addTask(Task task) {
        return taskDao.save(task);
    }

    @Override
    public Task getById(Integer id) {
        return taskDao.findById(id);
    }

    @Override
    public List<Task> loadTasks() {
        return taskDao.getAllTasks();
    }

    @Override
    public boolean modifyTask(Task task1, Task task2,String typeofswap) {
        return taskDao.update(task1, task2,typeofswap);
    }

    @Override
    public Task removeTask(Task task) {
        return taskDao.delete(task);
    }
}
