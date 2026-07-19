package automation.api.utils;

import java.util.HashMap;
import java.util.Map;

public class EmployeeDataBuilder {

    private EmployeeDataBuilder() {
    }

    public static Map<String, Object> createEmployeeInput() {

        long time = System.currentTimeMillis();

        Map<String, Object> input = new HashMap<>();

        input.put("name", "QA Automation");
        input.put("employeeId", "EMP" + time);
        input.put("email", "qa" + time + "@gmail.com");
        input.put("username", "qa" + time);
        input.put("gender", "MALE");
        input.put("phoneNumber", "08123456789");
        input.put("address", "Jakarta");
        input.put("employeeRole", "staff");

        return input;
    }

    public static Map<String, Object> updateEmployeeInput() {

        long time = System.currentTimeMillis();

        Map<String, Object> input = new HashMap<>();

        input.put("name", "QA Updated");
        input.put("email", "updated" + time + "@gmail.com");
        input.put("username", "updated" + time);
        input.put("gender", "MALE");
        input.put("phoneNumber", "08111111111");
        input.put("address", "Bandung");
        input.put("employeeRole", "staff");

        return input;
    }

}