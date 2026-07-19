package automation.api.utils;

import java.util.HashMap;
import java.util.Map;

public class BootcampDataBuilder {

    private BootcampDataBuilder() {
    }

    public static Map<String, Object> createInput() {

        long time = System.currentTimeMillis();

        Map<String, Object> input = new HashMap<>();

        input.put("title", "QA Bootcamp " + time);
        input.put("descriptions", "Automation");
        input.put("startedAt", "2026-07-10");
        input.put("finishedAt", "2026-08-10");

        return input;

    }

    public static Map<String, Object> updateInput() {

        long time = System.currentTimeMillis();

        Map<String, Object> input = new HashMap<>();

        input.put("title", "QA Bootcamp Updated " + time);
        input.put("descriptions", "Updated");
        input.put("startedAt", "2026-07-10");
        input.put("finishedAt", "2026-08-10");

        return input;

    }

}