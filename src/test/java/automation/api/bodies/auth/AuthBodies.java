package automation.api.bodies.auth;

import automation.utils.ConfigReader;

public final class AuthBodies {

    private AuthBodies() {
    }

    public static String login() {

        return String.format("""
                mutation {
                  login(
                    companyId: "%s"
                    usernameOrEmail: "%s"
                    password: "%s"
                  ) {
                    user {
                      id
                      name
                      email
                      username
                      role
                    }
                  }
                }
                """,
                ConfigReader.get("company.id"),
                ConfigReader.get("email"),
                ConfigReader.get("password"));
    }

}