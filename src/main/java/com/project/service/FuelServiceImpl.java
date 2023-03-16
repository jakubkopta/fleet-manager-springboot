package com.project.service;

import com.project.model.Fuel;
import com.project.model.FuelRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FuelServiceImpl implements FuelService{
    private FuelRepository fuelRepository;

    public FuelServiceImpl(FuelRepository fuelRepository) {
        this.fuelRepository = fuelRepository;
    }

    @Override
    public List<Fuel> getAllFuels() {
        return fuelRepository.findAll();
    }

    @Override
    public Fuel saveFuel(Fuel fuel) {
        return fuelRepository.save(fuel);
    }

    @Override
    public Fuel getFuelById(int id) {
        return fuelRepository.findById(id).get();
    }
}
