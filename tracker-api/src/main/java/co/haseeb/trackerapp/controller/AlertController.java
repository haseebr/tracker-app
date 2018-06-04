package co.haseeb.trackerapp.controller;

import co.haseeb.trackerapp.entity.Alert;
import co.haseeb.trackerapp.entity.Priority;
import co.haseeb.trackerapp.exceptions.BadRangeException;
import co.haseeb.trackerapp.service.AlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = "alerts")
public class AlertController {

    @Autowired
    private AlertService alertService;

    @GetMapping
    public Page<Alert> findByPriorityAndTimeBetween(@RequestParam("priority") Priority priority,
                                                    @RequestParam("start") @Nullable String start,
                                                    @RequestParam("end") @Nullable String end, Pageable pageable) {

        Date startTime;
        Date endTime;

        if (start == null) {
            startTime = new Date(System.currentTimeMillis() - 2 * 3600 * 1000);

        } else {
            startTime = new Date(Long.parseLong(start));

        }

        if (end == null) {
            endTime = new Date();
        } else {
            endTime = new Date(Long.parseLong(end));
        }

        if (endTime.before(startTime)) throw new BadRangeException("bad range exception");

        return alertService.findByPriorityAndTimeBetween(priority, startTime, endTime, pageable);
    }

    @GetMapping(value = "{vin}")
    public List<Alert> findByVin(@PathVariable("vin") String vin) {
        return alertService.findByVin(vin);
    }

    @GetMapping(value = "all")
    public List<Alert> findAll() {
        return alertService.findAll();
    }
}
