package co.haseeb.trackerapp.service.impl;

import co.haseeb.trackerapp.entity.Vehicle;
import co.haseeb.trackerapp.repository.VehicleRepository;
import co.haseeb.trackerapp.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {
    @Autowired
    private VehicleRepository vehicleRepository;

    public Page<Vehicle> findAll(Pageable pageable) {
        return vehicleRepository.findAll(pageable);
    }

    public Vehicle save(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    public List<Vehicle> saveAll(List<Vehicle> vehicles) {
        return vehicleRepository.saveAll(vehicles);
    }

    public Vehicle findByVin(String vin) {
        return vehicleRepository.findByVin(vin);
    }
}
