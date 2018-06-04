package co.haseeb.trackerapp.rules;

import co.haseeb.trackerapp.entity.Alert;
import co.haseeb.trackerapp.entity.Priority;
import co.haseeb.trackerapp.entity.Reading;
import co.haseeb.trackerapp.entity.Vehicle;
import co.haseeb.trackerapp.service.AlertService;
import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Fact;

public class BaseRule {

    @Action
    public void createAlert(@Fact("vehicle") Vehicle vehicle,
                            @Fact("reading") Reading reading,
                            @Fact("priority") Priority priority,
                            @Fact("reason") String reason,
                            @Fact("service") AlertService alertService) {
        Alert alert = new Alert();
        alert.setPriority(priority);
        alert.setReason(reason);
        alert.setTime(reading.getTimestamp());
        alert.setVin(vehicle.getVin());
        alert.setReadingId(reading.getId());
        alertService.save(alert);
    }
}
