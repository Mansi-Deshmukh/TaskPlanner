package com.taskplanner.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.FlashMapManager;

import com.taskplanner.entities.Task;
import com.taskplanner.exception.TaskException;
import com.taskplanner.repository.TaskRepo;

@Service
public class TaskServiceImpl implements TaskService{

    @Autowired(required = false)
    private TaskRepo taskRepo;

    @Override
    public Task addTask(Task task) {
        return taskRepo.save(task);
    }

    

    @Override
    public Task changeAssigneeToTask(Integer taskId, String assignee) throws TaskException {
        Task task = taskRepo.findById(taskId).orElseThrow(() -> new TaskException("Task not found with task Id : "+taskId) );
        task.setAssignee(assignee);

        return taskRepo.save(task);
    }

    @Override
    public Task changeTaskStatus(String status, Integer taskId) throws TaskException {
        
        Task task = taskRepo.findById(taskId).orElseThrow(() -> new TaskException("Task does not exits with task Id : "+taskId));
        task.setStatus(status);

        return taskRepo.save(task);
    }

    
}
