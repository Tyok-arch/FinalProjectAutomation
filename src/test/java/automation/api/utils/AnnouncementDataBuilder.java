package automation.api.utils;

import java.util.HashMap;
import java.util.Map;

public class AnnouncementDataBuilder {

    private AnnouncementDataBuilder() {
    }

    public static Map<String, Object> createInput() {

        long time = System.currentTimeMillis();

        Map<String, Object> input = new HashMap<>();

        input.put("title", "QA Announcement " + time);
        input.put("content", "Automation Test");
        input.put("isForAllEmployee", true);

        return input;

    }

    public static Map<String, Object> updateInput() {

        long time = System.currentTimeMillis();

        Map<String, Object> input = new HashMap<>();

        input.put("title", "QA Announcement Updated " + time);
        input.put("content", "Updated");
        input.put("isForAllEmployee", true);

        return input;

    }

}