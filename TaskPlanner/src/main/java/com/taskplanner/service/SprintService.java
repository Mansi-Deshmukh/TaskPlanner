package com.taskplanner.service;

import java.util.List;

import com.taskplanner.entities.Sprint;
import com.taskplanner.entities.Task;
import com.taskplanner.exception.SprintException;
import com.taskplanner.exception.TaskException;
import com.taskplanner.exception.UserNotFoundException;

public interface SprintService {

    public Sprint createString(Sprint sprint);

    public Task addTaskToSprint(Task task , Integer sprintId) throws SprintException;

    public List<Task> getTaskBySprint(Integer sprintId) throws SprintException, TaskException;

    public List<Task> getTaskAssigneeToUser(String assignee) throws UserNotFoundException;
    
}
