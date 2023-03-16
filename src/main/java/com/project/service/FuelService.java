package com.project.service;

import com.project.model.Fuel;

import java.util.List;

public interface FuelService {
    List<Fuel> getAllFuels();
    Fuel saveFuel(Fuel fuel);
    Fuel getFuelById(int id);
}
