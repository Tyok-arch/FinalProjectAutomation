package automation.api.base;

import automation.api.bodies.auth.AuthBodies;
import automation.api.utils.SessionManager;
import automation.utils.ConfigReader;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class BaseGraphQL {

    /**
     * Base request with Basic Authentication.
     */
    protected RequestSpecification baseRequest() {

        RestAssured.baseURI = ConfigReader.get("graphql.url");

        return given()
                .auth()
                .preemptive()
                .basic(
                        ConfigReader.get("graphql.username"),
                        ConfigReader.get("graphql.password")
                )
                .contentType("application/json");

    }

    /**
     * Login and save sid_b2b session.
     */
    protected void login() {

        Map<String, String> request = new HashMap<>();

        request.put("query", AuthBodies.login());

        Response response = baseRequest()
                .body(request)
                .post();

        response.then().log().all();

        String session = response.getDetailedCookie("sid_b2b").getValue();

        SessionManager.setSession(session);

        System.out.println("==================================");
        System.out.println("LOGIN SUCCESS");
        System.out.println("Session : " + session);
        System.out.println("==================================");

    }

    /**
     * Authenticated request using sid_b2b cookie.
     */
    protected RequestSpecification authRequest() {

        return baseRequest()
                .cookie(
                        "sid_b2b",
                        SessionManager.getSession()
                );

    }

}