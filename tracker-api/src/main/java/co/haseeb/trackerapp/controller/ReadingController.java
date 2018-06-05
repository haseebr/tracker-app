package co.haseeb.trackerapp.controller;

import co.haseeb.trackerapp.entity.GeoTag;
import co.haseeb.trackerapp.entity.Reading;
import co.haseeb.trackerapp.exceptions.BadRangeException;
import co.haseeb.trackerapp.service.ReadingService;
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
@RequestMapping(path = "readings")
@Api(value = "/readings", description = "Readings Endpoint")
public class ReadingController {

    @Autowired
    private ReadingService readingService;

    @PostMapping
    @ApiOperation(value = "Process Readings")
    public void postReading(
            @RequestBody Reading reading) {
        readingService.save(reading);
    }

    @GetMapping
    @ApiOperation(value = "Finds Readings by VIN and Time Range")
    public Page<GeoTag> findByVinAndTimestampBetween(
            @ApiParam(value = "VIN of the Vehicle", name = "vin")
            @RequestParam("vin") String vin,
            @Temporal(TemporalType.TIMESTAMP)
            @ApiParam(name = "start", value = "Start Time in milliseconds", defaultValue = "30 mins ago", example = "1496489798000", type = "Long")
            @RequestParam("start") @Nullable String start,
            @Temporal(TemporalType.TIMESTAMP)
            @ApiParam(name = "end", value = "End Time in milliseconds", defaultValue = "Current Time in Milliseconds", example = "1496489798000", type = "Long")
            @RequestParam("end") @Nullable String end, Pageable pageable) {

        Date startTime;
        Date endTime;

        if (start == null) {
            startTime = new Date(System.currentTimeMillis() - 1800 * 1000);

        } else {
            startTime = new Date(Long.parseLong(start));

        }

        if (end == null) {
            endTime = new Date();
        } else {
            endTime = new Date(Long.parseLong(end));
        }

        if (endTime.before(startTime)) throw new BadRangeException("bad range exception");

        return readingService.findByVinAndTimestampBetween(vin, startTime, endTime, pageable);
    }
}
