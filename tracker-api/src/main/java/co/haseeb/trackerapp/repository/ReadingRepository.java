package co.haseeb.trackerapp.repository;

import co.haseeb.trackerapp.entity.Reading;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ReadingRepository extends JpaRepository<Reading, String> {
    public Page<Reading> findByVinAndTimestampBetween(String vin, Date startTime, Date endTime, Pageable pageable);

    public List<Reading> findByVin(String vin, Pageable pageable);
}
