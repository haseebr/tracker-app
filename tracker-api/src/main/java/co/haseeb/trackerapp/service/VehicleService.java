package co.haseeb.trackerapp.service;

import co.haseeb.trackerapp.entity.Vehicle;

import java.util.List;

public interface VehicleService {
    public Vehicle findByVin(String vin);

    public List<Vehicle> findAll();

    public Vehicle save(Vehicle vehicle);

    public List<Vehicle> saveAll(List<Vehicle> vehicle);
}
