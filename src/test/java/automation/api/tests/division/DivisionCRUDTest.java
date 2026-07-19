package automation.api.tests.division;

import automation.api.base.BaseGraphQL;
import automation.api.bodies.division.DivisionBodies;
import automation.api.utils.DivisionDataBuilder;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class DivisionCRUDTest extends BaseGraphQL {

    @Test
    public void divisionCRUD() {

        login();

        String divisionId;

        /*
         * ===========================
         * CREATE DIVISION
         * ===========================
         */

        System.out.println("==============================");
        System.out.println("CREATE DIVISION");
        System.out.println("==============================");

        Map<String, Object> createRequest = new HashMap<>();
        Map<String, Object> createVariables = new HashMap<>();

        createVariables.put(
                "input",
                DivisionDataBuilder.createInput()
        );

        createRequest.put(
                "query",
                DivisionBodies.createDivisionQuery()
        );

        createRequest.put(
                "variables",
                createVariables
        );

        Response createResponse = authRequest()
                .body(createRequest)
                .post();

        createResponse.then().log().all();

        Assert.assertEquals(200, createResponse.statusCode());

        Assert.assertNull(
                createResponse.jsonPath().get("errors")
        );

        divisionId = createResponse.jsonPath()
                .getString("data.createDivision.id");

        Assert.assertNotNull(divisionId);

        System.out.println("Division ID : " + divisionId);

        /*
         * ===========================
         * GET DIVISION
         * ===========================
         */

        System.out.println("==============================");
        System.out.println("GET DIVISION");
        System.out.println("==============================");

        Map<String, Object> getRequest = new HashMap<>();
        Map<String, Object> getVariables = new HashMap<>();

        getVariables.put("id", divisionId);

        getRequest.put(
                "query",
                DivisionBodies.getDivisionQuery()
        );

        getRequest.put(
                "variables",
                getVariables
        );

        Response getResponse = authRequest()
                .body(getRequest)
                .post();

        getResponse.then().log().all();

        Assert.assertEquals(200, getResponse.statusCode());

        Assert.assertNull(
                getResponse.jsonPath().get("errors")
        );

        Assert.assertEquals(
                divisionId,
                getResponse.jsonPath()
                        .getString("data.divisionById.id")
        );

        /*
         * ===========================
         * UPDATE DIVISION
         * ===========================
         */

        System.out.println("==============================");
        System.out.println("UPDATE DIVISION");
        System.out.println("==============================");

        Map<String, Object> updateRequest = new HashMap<>();
        Map<String, Object> updateVariables = new HashMap<>();

        updateVariables.put("id", divisionId);

        updateVariables.put(
                "input",
                DivisionDataBuilder.updateInput()
        );

        updateRequest.put(
                "query",
                DivisionBodies.updateDivisionQuery()
        );

        updateRequest.put(
                "variables",
                updateVariables
        );

        Response updateResponse = authRequest()
                .body(updateRequest)
                .post();

        updateResponse.then().log().all();

        Assert.assertEquals(200, updateResponse.statusCode());

        Assert.assertNull(
                updateResponse.jsonPath().get("errors")
        );

        Assert.assertEquals(
                divisionId,
                updateResponse.jsonPath()
                        .getString("data.updateDivision.id")
        );

        /*
         * ===========================
         * DELETE DIVISION
         * ===========================
         */

        System.out.println("==============================");
        System.out.println("DELETE DIVISION");
        System.out.println("==============================");

        Map<String, Object> deleteRequest = new HashMap<>();
        Map<String, Object> deleteVariables = new HashMap<>();

        deleteVariables.put("id", divisionId);

        deleteRequest.put(
                "query",
                DivisionBodies.deleteDivisionQuery()
        );

        deleteRequest.put(
                "variables",
                deleteVariables
        );

        Response deleteResponse = authRequest()
                .body(deleteRequest)
                .post();

        deleteResponse.then().log().all();

        Assert.assertEquals(200, deleteResponse.statusCode());

        Assert.assertNull(
                deleteResponse.jsonPath().get("errors")
        );

        Assert.assertTrue(
                deleteResponse.jsonPath()
                        .getBoolean("data.deleteDivision")
        );

        System.out.println("==============================");
        System.out.println("DIVISION CRUD SUCCESS");
        System.out.println("==============================");

    }

}