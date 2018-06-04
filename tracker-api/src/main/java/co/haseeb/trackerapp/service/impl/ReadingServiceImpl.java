package co.haseeb.trackerapp.service.impl;

import co.haseeb.trackerapp.entity.Reading;
import co.haseeb.trackerapp.entity.Vehicle;
import co.haseeb.trackerapp.repository.ReadingRepository;
import co.haseeb.trackerapp.service.AlertService;
import co.haseeb.trackerapp.service.ReadingService;
import co.haseeb.trackerapp.service.VehicleService;
import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReadingServiceImpl implements ReadingService {

    @Autowired
    private VehicleService vehicleService;
    @Autowired
    private ReadingRepository readingRepository;
    @Autowired
    private AlertService alertService;
    @Autowired
    private RulesEngine rulesEngine;
    @Autowired
    private Rules rules;


    @Override
    public void save(Reading reading) {
        Vehicle vehicle = vehicleService.findByVin(reading.getVin());
        readingRepository.save(reading);
        Facts facts = new Facts();
        facts.put("vehicle", vehicle);
        facts.put("reading", reading);
        facts.put("service", alertService);
        rulesEngine.fire(rules, facts);
    }
}
