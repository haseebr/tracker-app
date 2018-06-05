package co.haseeb.trackerapp.controller;

import co.haseeb.trackerapp.entity.Vehicle;
import co.haseeb.trackerapp.service.VehicleService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
    @ApiOperation(value = "List all Vehicles")
    public Page<Vehicle> allVehicles(Pageable pageable) {
        return vehicleService.findAll(pageable);
    }

    @PutMapping
    @ApiOperation(value = "Process Vehicles")
    public List<Vehicle> putVehicles(@RequestBody List<Vehicle> vehicles) {
        return vehicleService.saveAll(vehicles);
    }

    @GetMapping(value = "{vin}")
    @ApiOperation(value = "Vehicle info by VIN")
    public Vehicle findByVin(
            @ApiParam(value = "VIN of the Vehicle", name = "vin")
            @PathVariable("vin") String vin) {
        return vehicleService.findByVin(vin);

    }
}
