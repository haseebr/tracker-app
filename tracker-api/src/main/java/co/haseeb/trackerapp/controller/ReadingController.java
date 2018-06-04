package co.haseeb.trackerapp.controller;

import co.haseeb.trackerapp.entity.GeoTag;
import co.haseeb.trackerapp.entity.Reading;
import co.haseeb.trackerapp.exceptions.BadRangeException;
import co.haseeb.trackerapp.service.ReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@CrossOrigin
@RequestMapping(path = "readings")
public class ReadingController {

    @Autowired
    private ReadingService readingService;

    @PostMapping
    public void postReading(@RequestBody Reading reading) {
        readingService.save(reading);
    }

    @GetMapping
    public Page<GeoTag> findByVinAndTimestampBetween(@RequestParam("vin") String vin,
                                                     @RequestParam("start") @Nullable String start,
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
