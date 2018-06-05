package co.haseeb.trackerapp.rules;

import co.haseeb.trackerapp.entity.Priority;
import co.haseeb.trackerapp.entity.Reading;
import co.haseeb.trackerapp.entity.Vehicle;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Rule;
import org.jeasy.rules.api.Facts;

@Rule
public class LowFuelVolumeRule extends BaseRule {

    @Condition
    public boolean fuelCheck(Facts facts) {
        Reading reading = facts.get("reading");
        Vehicle vehicle = facts.get("vehicle");
        facts.put("priority", Priority.MEDIUM);
        facts.put("reason", "Low Fuel");
        return reading.getFuelVolume() < (vehicle.getMaxFuelVolume() * 0.1);
    }
}
