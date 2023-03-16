package com.project.model;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "roles")
@Getter
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;
}
