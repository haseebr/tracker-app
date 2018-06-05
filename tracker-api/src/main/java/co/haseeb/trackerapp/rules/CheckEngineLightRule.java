package co.haseeb.trackerapp.rules;

import co.haseeb.trackerapp.entity.Priority;
import co.haseeb.trackerapp.entity.Reading;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Rule;
import org.jeasy.rules.api.Facts;

@Rule
public class CheckEngineLightRule extends BaseRule {

    @Condition
    public boolean checkEngineLight(Facts facts) {
        Reading reading = facts.get("reading");
        facts.put("priority", Priority.LOW);
        facts.put("reason", "Check Engine Light On");
        return reading.isCheckEngineLightOn();
    }
}
