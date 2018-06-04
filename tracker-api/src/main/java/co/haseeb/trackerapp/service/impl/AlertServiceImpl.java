package co.haseeb.trackerapp.service.impl;

import co.haseeb.trackerapp.entity.Alert;
import co.haseeb.trackerapp.entity.Priority;
import co.haseeb.trackerapp.repository.AlertRepository;
import co.haseeb.trackerapp.service.AlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AlertServiceImpl implements AlertService {


    @Autowired
    private AlertRepository alertRepository;

    @Override
    public void save(Alert alert) {
        alertRepository.save(alert);
    }

    @Override
    public List<Alert> findByVin(String vin) {
        return alertRepository.findByVin(vin);
    }

    @Override
    public List<Alert> findAll() {
        return alertRepository.findAll();
    }

    @Override
    public List<Alert> findByPriorityAndTimeBetween(Priority priority, Date startTime, Date endTime, Pageable pageable) {
        return alertRepository.findByPriorityAndTimeBetween(priority, startTime, endTime, pageable);
    }
}
