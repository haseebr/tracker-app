package co.haseeb.trackerapp.repository;

import co.haseeb.trackerapp.entity.Alert;
import co.haseeb.trackerapp.entity.Priority;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface AlertRepository extends JpaRepository<Alert, String> {
    public Page<Alert> findByVin(String vin, Pageable pageable);

    public Page<Alert> findByPriorityAndTimeBetween(Priority priority, Date startTime, Date endTime, Pageable pageable);
}
