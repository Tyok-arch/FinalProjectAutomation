package automation.api.utils;

import java.util.HashMap;
import java.util.Map;

public class ProgramDataBuilder {

    private ProgramDataBuilder() {
    }

    public static Map<String, Object> createInput() {

        long time = System.currentTimeMillis();

        Map<String, Object> input = new HashMap<>();

        input.put("title", "QA Program " + time);
        input.put("description", "Automation");
        input.put("type", "onboarding");
        input.put("isSequential", false);

        return input;

    }

    public static Map<String, Object> updateInput() {

        long time = System.currentTimeMillis();

        Map<String, Object> input = new HashMap<>();

        input.put("title", "QA Program Updated " + time);
        input.put("description", "Updated");
        input.put("type", "onboarding");

        return input;

    }

}