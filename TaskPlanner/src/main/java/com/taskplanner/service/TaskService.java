package com.taskplanner.service;

import com.taskplanner.entities.Task;
import com.taskplanner.exception.TaskException;

public interface TaskService {
    
    public Task addTask(Task task);

    public Task changeAssigneeToTask(Integer taskId, String assignee) throws TaskException;

    public Task changeTaskStatus(String Status, Integer taskId) throws TaskException;

    
    
}
