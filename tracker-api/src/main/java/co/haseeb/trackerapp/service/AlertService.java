package co.haseeb.trackerapp.service;

import co.haseeb.trackerapp.entity.Alert;
import co.haseeb.trackerapp.entity.Priority;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;

public interface AlertService {
    public void save(Alert alert);

    public Page<Alert> findByPriorityAndTimeBetween(Priority priority, Date startTime, Date endTime, Pageable pageable);

    public Page<Alert> findByVin(String vin, Pageable pageable);

    public Page<Alert> findAll(Pageable pageable);
}
