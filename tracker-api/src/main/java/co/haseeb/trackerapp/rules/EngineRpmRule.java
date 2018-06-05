package co.haseeb.trackerapp.rules;

import co.haseeb.trackerapp.entity.Priority;
import co.haseeb.trackerapp.entity.Reading;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Rule;
import org.jeasy.rules.api.Facts;

@Rule
public class EngineRpmRule extends BaseRule {

    @Condition
    public boolean engineRpmCheck(Facts facts) {
        Reading reading = facts.get("reading");
        facts.put("priority", Priority.HIGH);
        facts.put("reason", "High Engine RPM");
        return reading.isCheckEngineLightOn();
    }
}
