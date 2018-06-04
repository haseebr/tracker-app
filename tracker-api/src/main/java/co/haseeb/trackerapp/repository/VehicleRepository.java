package co.haseeb.trackerapp.repository;

import co.haseeb.trackerapp.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, String> {
    public Vehicle findByVin(String vin);
}