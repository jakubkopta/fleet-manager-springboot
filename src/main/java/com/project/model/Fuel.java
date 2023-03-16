package com.project.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "fuels")
@Data
public class Fuel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int mileage;
    private float cost;
    private LocalDate day;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vehicle_id", referencedColumnName = "id")
    private Vehicle vehicle;

    @PrePersist
    void prePersist() {
        day = LocalDate.now();
    }

    public void assignVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
