package automation.api.utils;

public class SessionManager {

    private static String session;

    public static void setSession(String sessionId) {

        session = sessionId;

    }

    public static String getSession() {

        return session;

    }

}