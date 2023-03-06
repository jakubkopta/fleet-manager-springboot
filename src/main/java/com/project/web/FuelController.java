package com.project.web;

import com.project.logic.FuelService;
import com.project.logic.VehicleService;
import com.project.model.Fuel;
import com.project.model.Vehicle;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/fuels")
public class FuelController {
    private FuelService fuelService;
    private VehicleService vehicleService;

    public FuelController(FuelService fuelService, VehicleService vehicleService) {
        this.fuelService = fuelService;
        this.vehicleService = vehicleService;
    }

    @GetMapping
    public String readAllFuels(Model model) {
        model.addAttribute("fuels", fuelService.getAllFuels());
        return "fuels";
    }

    @GetMapping("/new")
    public String createFuel(Model model) {
        Fuel fuel = new Fuel();
        model.addAttribute("fuel", fuel);
        return "create_fuel";
    }

    @PostMapping
    public String saveFuel(@ModelAttribute("fuel") Fuel fuel) {
        fuelService.saveFuel(fuel);
        return "redirect:/fuels";
    }

    @PostMapping("/{fuelsId}/vehicles/{vehicleId}")
    public String assignVehicleToFuel(
            @PathVariable int fuelsId,
            @PathVariable int vehicleId
    ) {
        Fuel fuel = fuelService.getFuelById(fuelsId);
        Vehicle vehicle = vehicleService.getVehicleById(vehicleId);
        fuel.assignVehicle(vehicle);
        fuelService.saveFuel(fuel);
        return "redirect:/fuels";
    }
}
