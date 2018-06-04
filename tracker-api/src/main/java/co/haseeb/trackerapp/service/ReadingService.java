package co.haseeb.trackerapp.service;

import co.haseeb.trackerapp.entity.GeoTag;
import co.haseeb.trackerapp.entity.Reading;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;

public interface ReadingService {
    public void save(Reading reading);

    public Page<GeoTag> findByVinAndTimestampBetween(String vin, Date startTime, Date endTime, Pageable pageable);
}
