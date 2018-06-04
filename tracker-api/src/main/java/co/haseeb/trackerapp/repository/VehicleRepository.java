package co.haseeb.trackerapp.repository;

import co.haseeb.trackerapp.entity.Vehicle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, String> {
    public Page<Vehicle> findAll(Pageable pageable);

    public Vehicle findByVin(String vin);
}