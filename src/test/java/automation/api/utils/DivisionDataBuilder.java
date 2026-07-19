package automation.api.utils;

import java.util.HashMap;
import java.util.Map;

public class DivisionDataBuilder {

    private DivisionDataBuilder() {
    }

    public static Map<String, Object> createInput() {

        long time = System.currentTimeMillis();

        Map<String, Object> input = new HashMap<>();

        input.put("name", "QA Division " + time);
        input.put("description", "Automation");

        return input;

    }

    public static Map<String, Object> updateInput() {

        long time = System.currentTimeMillis();

        Map<String, Object> input = new HashMap<>();

        input.put("name", "QA Division Updated " + time);
        input.put("description", "Updated");

        return input;

    }

}