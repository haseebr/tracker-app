package co.haseeb.trackerapp.controller;

import co.haseeb.trackerapp.entity.Reading;
import co.haseeb.trackerapp.service.ReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}
