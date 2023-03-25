package com.taskplanner.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="task")
@Data
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "taskId")
    private Integer taskId;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;
    
    @Column(name = "type")
    // @Enumerated(EnumType.STRING)
    private TaskType type;

    @Column(name = "assignee")
    private String assignee;

    @Column(name = "status")
    private String status;

    // @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "sprint_id")
    private Sprint sprint;
}
