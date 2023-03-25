package com.taskplanner.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.taskplanner.entities.Task;

@Repository
public interface TaskRepo extends JpaRepository<Task, Integer>{
    
    public List<Task> findByAssignee(String assignee);
}
