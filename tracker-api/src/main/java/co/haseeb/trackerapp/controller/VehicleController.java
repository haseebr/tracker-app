package co.haseeb.trackerapp.controller;

import co.haseeb.trackerapp.entity.Vehicle;
import co.haseeb.trackerapp.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = "vehicles")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @GetMapping
    public Page<Vehicle> allVehicles(Pageable pageable) {
        return vehicleService.findAll(pageable);
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
