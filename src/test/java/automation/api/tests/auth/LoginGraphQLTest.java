package automation.api.tests.auth;

import automation.api.base.BaseGraphQL;
import automation.api.bodies.auth.AuthBodies;
import automation.api.utils.SessionManager;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class LoginGraphQLTest extends BaseGraphQL {

    @Test
    public void loginSuccess() {

        Map<String, String> request = new HashMap<>();

        request.put("query", AuthBodies.login());

        Response response = baseRequest()
                .body(request)
                .post();

        response.prettyPrint();

        Assert.assertEquals(200, response.getStatusCode());

        String session = response.getDetailedCookie("sid_b2b").getValue();

        Assert.assertNotNull(session);

        SessionManager.setSession(session);

        System.out.println("Session ID : " + session);

    }
}