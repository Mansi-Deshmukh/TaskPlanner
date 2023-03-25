package com.taskplanner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.taskplanner.entities.Sprint;

@Repository
public interface SprintRepo extends JpaRepository<Sprint, Integer> {

}
