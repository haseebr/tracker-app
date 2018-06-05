package co.haseeb.trackerapp.rules;

import co.haseeb.trackerapp.entity.Priority;
import co.haseeb.trackerapp.entity.Reading;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Rule;
import org.jeasy.rules.api.Facts;

@Rule
public class LowEngineCoolantRule extends BaseRule {

    @Condition
    public boolean coolantCheck(Facts facts) {
        Reading reading = facts.get("reading");
        facts.put("priority", Priority.LOW);
        facts.put("reason", "Low Coolant");
        return reading.isEngineCoolantLow();
    }
}
