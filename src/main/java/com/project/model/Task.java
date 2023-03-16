package com.project.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity
@Table(name = "tasks")
@Data
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "Task description cannot be empty")
    private String description;
    private boolean done;
    private LocalDate created;

    @PrePersist
    void prePersist() {
        created = LocalDate.now();
    }
}
