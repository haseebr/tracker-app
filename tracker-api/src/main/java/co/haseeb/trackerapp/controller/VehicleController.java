package co.haseeb.trackerapp.controller;

import co.haseeb.trackerapp.entity.Vehicle;
import co.haseeb.trackerapp.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = "vehicles")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @GetMapping
    public List<Vehicle> allVehicles() {
        return vehicleService.findAll();
    }

    @PutMapping
    public List<Vehicle> putVehicles(@RequestBody List<Vehicle> vehicles) {
        return vehicleService.saveAll(vehicles);
    }

    @GetMapping(value = "{vin}")
    public Vehicle findByVin(@PathVariable("vin") String vin) {
        return vehicleService.findByVin(vin);

    }
}
