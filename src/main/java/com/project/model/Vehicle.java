package com.project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "vehicles")
@Data
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String brand;
    private String model;
    private String plate;
    private boolean availability;
    private Date inspection;
    @JsonIgnore
    @OneToMany(mappedBy = "vehicle")
    private List<Fuel> fuels;
}
