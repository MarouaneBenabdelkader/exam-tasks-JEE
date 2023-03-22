package com.example.examtasks.dao;

import com.example.examtasks.models.Task;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class TaskDaoMemory implements TaskDao{
    private static List<Task> tasks;
    private static Integer myId;
    public TaskDaoMemory(){
        tasks = new ArrayList<>();
        myId = 0;
    }


    @Override
    public Task save(Task task) {
        if(task.getContent().equals(""))
            return null;
        task.setId(myId++);
        tasks.add(task);
        return task;
    }

    @Override
    public Task findById(Integer id) {
        for (Task task : tasks){
            if(task.getId().equals(id))
                return task;
        }
        return null;
    }

    @Override
    public List<Task> getAllTasks() {
        return tasks;
    }

    @Override
    public boolean update(Task task1, Task task2,String typeofswap) {
        if(typeofswap.equals("down")){
            Collections.swap(tasks,task1.getId(),task2.getId());
            for (Task task : tasks) {
                if(task.equals(task1)) {
                    task1.setId(task2.getId());
                    task2.setId(task1.getId() - 1);
                    return true;
                }
            }
        }
        if(typeofswap.equals("top")){
            Collections.swap(tasks,task1.getId(),task2.getId());
            for (Task task : tasks) {
                if(task.equals(task1)) {
                    task2.setId(task1.getId());
                    task1.setId(task2.getId() + 1);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Task delete(Task task) {
        for (Task task1:tasks) {
            if(task.getId().equals(task1.getId())){
                tasks.remove(task1);
                myId = 0;
                for (Task task2:tasks) {
                    task2.setId(myId++);
                }
                return task1;
            }
        }




        //if the task is not found a null will be returned
        return null;
    }
}
