package com.taskplanner.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taskplanner.entities.Sprint;
import com.taskplanner.entities.Task;
import com.taskplanner.exception.SprintException;
import com.taskplanner.exception.TaskException;
import com.taskplanner.exception.UserNotFoundException;
import com.taskplanner.repository.SprintRepo;
import com.taskplanner.repository.TaskRepo;


@Service
public class SprintServiceImpl implements SprintService{

    @Autowired(required = false)
    private SprintRepo sprintRepo; 

    @Autowired(required = false)
    private TaskRepo taskRepo;

    /**
     * saving sprint to sprintRepo.
     */

    public Sprint createString(Sprint sprint){
        
        return sprintRepo.save(sprint);

    }

    /**
     * Adding task to sprint : 
     * sprint : check sprint , add task to sprint.
     * task : task also need to save sprint,  .
     */

    @Override
    public Task addTaskToSprint(Task task, Integer sprintId) throws SprintException {
        Optional<Sprint> sprint = sprintRepo.findById(sprintId);

        if(sprint.isEmpty()){
            throw new SprintException("Sprint does not exits with sprint Id : "+ sprintId);
        }

        Sprint saveSprint = sprint.get();
        saveSprint.getAssingedTasks().add(task);
        task.setSprint(saveSprint);
        taskRepo.save(task);
        sprintRepo.save(saveSprint);

        return task;
      
       

    }

    
    @Override
    public List<Task> getTaskBySprint(Integer sprintId) throws SprintException, TaskException {
        Sprint sprint = sprintRepo.findById(sprintId).orElseThrow(() -> new SprintException("Sprint not found with id :"+ sprintId) );

        if(sprint.getAssingedTasks().isEmpty()){
            throw new TaskException("No task added to sprint :"+ sprint.getName());
        }
       return sprint.getAssingedTasks();

    }

    /**
     * create method in taskRepo to get assignee/user
     * if(tasklist== empty) user not found , hence return UserNotFoundException.
     */
    @Override
    public List<Task> getTaskAssigneeToUser(String assignee) throws UserNotFoundException {
        
        List<Task> taskList = taskRepo.findByAssignee(assignee);
        
        if(taskList.isEmpty()){
             throw new UserNotFoundException("User does not exits with the name : "+ assignee);
        }

        return taskList;
    }
    
}
