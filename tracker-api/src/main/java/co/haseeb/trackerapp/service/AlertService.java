package co.haseeb.trackerapp.service;

import co.haseeb.trackerapp.entity.Alert;
import co.haseeb.trackerapp.entity.Priority;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;

public interface AlertService {
    public void save(Alert alert);

    public List<Alert> findByPriorityAndTimeBetween(Priority priority, Date startTime, Date endTime, Pageable pageable);

    public List<Alert> findByVin(String vin);

    public List<Alert> findAll();
}
