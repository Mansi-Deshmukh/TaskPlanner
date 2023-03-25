package com.taskplanner.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taskplanner.entities.Sprint;
import com.taskplanner.entities.Task;
import com.taskplanner.exception.SprintException;
import com.taskplanner.exception.TaskException;
import com.taskplanner.exception.UserNotFoundException;
import com.taskplanner.service.SprintService;
import com.taskplanner.service.TaskService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/sprint")
public class SprintController {
    
    @Autowired
    private TaskService taskService;

    @Autowired
    private SprintService sprintService;

    @PostMapping("/add_sprint")
    public ResponseEntity<Sprint> createSprintHandler(@RequestBody Sprint sprint){
        Sprint save = sprintService.createString(sprint);
        return new ResponseEntity<Sprint>(save, HttpStatus.CREATED);
    }
    
    @PostMapping("/add_task/{sprintId}")
    public ResponseEntity<Task> addTaskToSprintHandler(@RequestBody Task task, @PathVariable("sprintId") Integer sprintId ) throws SprintException{

        Task save = sprintService.addTaskToSprint(task ,sprintId);
        return new ResponseEntity<Task>(save, HttpStatus.OK);
    }

    @GetMapping("/getTask/{sprintId}")
        public ResponseEntity<List<Task>> getTaskBySprint(@PathVariable("sprintId") Integer sprintId) throws SprintException, TaskException{
    
            List<Task> taskList = sprintService.getTaskBySprint(sprintId);
    
            return new ResponseEntity<List<Task>>(taskList, HttpStatus.OK);
    
        }

        @GetMapping("/getTaskByUser/{assignee}")
        public ResponseEntity<List<Task>> getTaskByUser(@PathVariable String assignee) throws UserNotFoundException{
    
            List<Task> taskList = sprintService.getTaskAssigneeToUser(assignee);
    
            return new ResponseEntity<List<Task>>(taskList, HttpStatus.OK);
    
        }
}
