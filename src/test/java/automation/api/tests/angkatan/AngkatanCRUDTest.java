package automation.api.tests.angkatan;

import automation.api.base.BaseGraphQL;
import automation.api.bodies.angkatan.AngkatanBodies;
import automation.api.utils.AngkatanDataBuilder;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class AngkatanCRUDTest extends BaseGraphQL {

    @Test
    public void angkatanCRUD() {

        login();

        Number angkatanId;

        /*
         * ===========================
         * CREATE ANGKATAN
         * ===========================
         */

        System.out.println("==============================");
        System.out.println("CREATE ANGKATAN");
        System.out.println("==============================");

        Map<String, Object> createRequest = new HashMap<>();
        Map<String, Object> createVariables = new HashMap<>();

        createVariables.put(
                "input",
                AngkatanDataBuilder.createInput()
        );

        createRequest.put(
                "query",
                AngkatanBodies.createAngkatanQuery()
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

        Assert.assertNull(createResponse.jsonPath().get("errors"));

        angkatanId = createResponse.jsonPath()
                .get("data.createAngkatan.id");

        Assert.assertNotNull(angkatanId);

        System.out.println("Angkatan ID : " + angkatanId);

        /*
         * ===========================
         * LIST ANGKATAN
         * ===========================
         */

        System.out.println("==============================");
        System.out.println("LIST ANGKATAN");
        System.out.println("==============================");

        Map<String, Object> listRequest = new HashMap<>();

        listRequest.put(
                "query",
                AngkatanBodies.listAngkatanQuery()
        );

        Response listResponse = authRequest()
                .body(listRequest)
                .post();

        listResponse.then().log().all();

        Assert.assertEquals(200, listResponse.statusCode());

        Assert.assertNull(listResponse.jsonPath().get("errors"));

        /*
         * ===========================
         * GET ANGKATAN
         * ===========================
         */

        System.out.println("==============================");
        System.out.println("GET ANGKATAN");
        System.out.println("==============================");

        Map<String, Object> getRequest = new HashMap<>();
        Map<String, Object> getVariables = new HashMap<>();

        getVariables.put("id", angkatanId);

        getRequest.put(
                "query",
                AngkatanBodies.getAngkatanQuery()
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

        Assert.assertEquals(
                angkatanId.floatValue(),
                getResponse.jsonPath().getFloat("data.angkatanById.id"),
                0.0
        );

        /*
         * ===========================
         * UPDATE ANGKATAN
         * ===========================
         */

        System.out.println("==============================");
        System.out.println("UPDATE ANGKATAN");
        System.out.println("==============================");

        Map<String, Object> updateRequest = new HashMap<>();
        Map<String, Object> updateVariables = new HashMap<>();

        updateVariables.put("id", angkatanId);

        updateVariables.put(
                "input",
                AngkatanDataBuilder.updateInput()
        );

        updateRequest.put(
                "query",
                AngkatanBodies.updateAngkatanQuery()
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

        Assert.assertNull(updateResponse.jsonPath().get("errors"));

        /*
         * ===========================
         * DELETE ANGKATAN
         * ===========================
         */

        System.out.println("==============================");
        System.out.println("DELETE ANGKATAN");
        System.out.println("==============================");

        Map<String, Object> deleteRequest = new HashMap<>();
        Map<String, Object> deleteVariables = new HashMap<>();

        deleteVariables.put("id", angkatanId);

        deleteRequest.put(
                "query",
                AngkatanBodies.deleteAngkatanQuery()
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

        Assert.assertNull(deleteResponse.jsonPath().get("errors"));

        System.out.println("==============================");
        System.out.println("ANGKATAN CRUD SUCCESS");
        System.out.println("==============================");

    }

}