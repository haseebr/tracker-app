package co.haseeb.trackerapp.rules;

import co.haseeb.trackerapp.entity.Priority;
import co.haseeb.trackerapp.entity.Reading;
import co.haseeb.trackerapp.entity.Tires;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Rule;
import org.jeasy.rules.api.Facts;

@Rule
public class LowTirePressureRule extends BaseRule {

    @Condition
    public boolean tirePressureCheck(Facts facts) {
        Reading reading = facts.get("reading");
        Tires tires = reading.getTires();
        facts.put("priority", Priority.LOW);
        facts.put("reason", "Low Tire Pressure");
        return tires.getFrontLeft() < 32 || tires.getFrontLeft() > 36 ||
                tires.getFrontRight() < 32 || tires.getFrontRight() > 36 ||
                tires.getRearLeft() < 32 || tires.getRearLeft() > 36 ||
                tires.getRearRight() < 32 || tires.getRearRight() > 36;
    }
}
