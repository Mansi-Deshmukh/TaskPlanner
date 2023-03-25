package com.taskplanner.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taskplanner.entities.Task;
import com.taskplanner.exception.TaskException;
import com.taskplanner.service.TaskService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api")
public class TaskController {
    
    @Autowired(required = false)
    private TaskService taskService;

    @PostMapping("/add")
    public ResponseEntity<Task> addTaskHandler(@RequestBody Task task){
        Task saveTask = taskService.addTask(task);
        return new ResponseEntity<Task>(saveTask, HttpStatus.CREATED);
    }

//     @GetMapping("/getTask")
//     public ResponseEntity<List<Task>> getUserById() {

//         List<Task> getUser = taskService.getTask();

//         return new ResponseEntity<List<Task>>(getUser, HttpStatus.OK);

//     }

    @PutMapping("/change_status/{taskId}/{status}")
    public  ResponseEntity<Task> changeTaskStatusHandler(@PathVariable("status") String status, @PathVariable("taskId") Integer taskId) throws TaskException{
        
        return new ResponseEntity<Task>(taskService.changeTaskStatus(status, taskId), HttpStatus.OK);
    }

    @PutMapping("/change_assignee/{taskId}/{assignee}")
    public  ResponseEntity<Task> assigneeTask(@PathVariable("taskId") Integer taskId, @PathVariable String assignee) throws TaskException{
        
        return new ResponseEntity<Task>(taskService.changeAssigneeToTask( taskId, assignee), HttpStatus.OK);
    }

}
