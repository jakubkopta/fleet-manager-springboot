package com.project.service;

import com.project.model.Vehicle;

import java.util.List;

public interface VehicleService {
    List<Vehicle> getAllVehicles();
    Vehicle saveVehicle(Vehicle vehicle);
    Vehicle getVehicleById(int id);
    Vehicle updateVehicle(Vehicle vehicle);
    void deleteVehicleById(int id);
}
