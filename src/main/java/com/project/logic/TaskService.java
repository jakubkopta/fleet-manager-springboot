package com.project.logic;

import com.project.model.Task;

import java.util.List;

public interface TaskService {
    List<Task> getAllTasks();
    Task saveTask(Task task);
    Task getTaskById(int id);
    Task updateTask(Task task);
    void deleteTaskById(int id);
}
