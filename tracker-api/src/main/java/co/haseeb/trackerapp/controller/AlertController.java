package co.haseeb.trackerapp.controller;

import co.haseeb.trackerapp.entity.Alert;
import co.haseeb.trackerapp.entity.Priority;
import co.haseeb.trackerapp.exceptions.BadRangeException;
import co.haseeb.trackerapp.service.AlertService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Temporal;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import javax.persistence.TemporalType;
import java.util.Date;

@RestController
@CrossOrigin
@RequestMapping(path = "alerts")
@Api(value = "/alerts", description = "Alerts Endpoint")
public class AlertController {

    @Autowired
    private AlertService alertService;

    @GetMapping
    @ApiOperation(value = "Finds Alerts by Priority and Time Range")
    public Page<Alert> findByPriorityAndTimeBetween(
            @ApiParam(value = "Priority of the Alert", name = "priority", allowableValues = "LOW, MEDIUM, HIGH")
            @RequestParam("priority") Priority priority,
            @Temporal(TemporalType.TIMESTAMP)
            @ApiParam(name = "start", value = "Start Time in milliseconds", defaultValue = "Two hours ago", example = "1496489798000", type = "Long")
            @RequestParam("start") @Nullable String start,
            @Temporal(TemporalType.TIMESTAMP)
            @ApiParam(name = "end", value = "End Time in milliseconds", defaultValue = "Current Time in Milliseconds", example = "1496489798000", type = "Long")
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
    @ApiOperation(value = "Finds all alerts for a Vehicle by vin")
    public Page<Alert> findByVin(
            @ApiParam(name = "vin", value = "VIN of Vehicle", example = "1FMYU02143KB34432", type = "String")
            @PathVariable("vin") String vin, Pageable pageable) {
        return alertService.findByVin(vin, pageable);
    }

    @GetMapping(value = "all")
    @ApiOperation(value = "Finds all Alerts")
    public Page<Alert> findAll(Pageable pageable) {
        Page<Alert> alerts = alertService.findAll(pageable);
//        List<Alert> alertsList = alerts.getContent();
        return alerts;
    }
}
