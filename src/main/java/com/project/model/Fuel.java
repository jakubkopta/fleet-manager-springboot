package com.project.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "fuels")
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

    public Fuel() {
    }

    public Fuel(int id, int mileage, float cost, LocalDate day, Vehicle vehicle) {
        this.id = id;
        this.mileage = mileage;
        this.cost = cost;
        this.day = day;
        this.vehicle = vehicle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public LocalDate getDay() {
        return day;
    }

    public void setDay(LocalDate day) {
        this.day = day;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @PrePersist
    void prePersist() {
        day = LocalDate.now();
    }

    public void assignVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
