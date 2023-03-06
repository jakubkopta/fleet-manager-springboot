package com.project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "vehicles")
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

    public Vehicle() {
    }

    public Vehicle(int id, String brand, String model, String plate, boolean availability, Date inspection, List<Fuel> fuels) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.plate = plate;
        this.availability = availability;
        this.inspection = inspection;
        this.fuels = fuels;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public Date getInspection() {
        return inspection;
    }

    public void setInspection(Date inspection) {
        this.inspection = inspection;
    }

    public List<Fuel> getFuels() {
        return fuels;
    }

    public void setFuels(List<Fuel> fuels) {
        this.fuels = fuels;
    }
}
