package co.haseeb.trackerapp.repository;

import co.haseeb.trackerapp.entity.Reading;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReadingRepository extends JpaRepository<Reading, String> {
}
