package co.haseeb.trackerapp.service;

import co.haseeb.trackerapp.entity.Vehicle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface VehicleService {
    public Vehicle findByVin(String vin);

    public Page<Vehicle> findAll(Pageable pageable);

    public Vehicle save(Vehicle vehicle);

    public List<Vehicle> saveAll(List<Vehicle> vehicle);
}
