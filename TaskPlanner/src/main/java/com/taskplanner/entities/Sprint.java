package com.taskplanner.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name ="sprint")
@Data
@NoArgsConstructor
public class Sprint {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "sprintId")
    private Integer sprintId;

    @Column(name = "sprintName")
    private String sprintName;

    @JsonIgnore
    // @Column(name = "taskList")
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sprint")
    // @JoinColumn(name = "sprint_id")
    private List<Task> assingedTasks = new ArrayList<>();

}
