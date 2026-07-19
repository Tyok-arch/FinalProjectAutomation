package automation.api.tests.bootcamp;

import automation.api.base.BaseGraphQL;
import automation.api.bodies.bootcamp.BootcampBodies;
import automation.api.utils.BootcampDataBuilder;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class BootcampCRUDTest extends BaseGraphQL {

    @Test
    public void bootcampCRUD() {

        login();

        String bootcampId;

        /*
         * ===========================
         * CREATE BOOTCAMP
         * ===========================
         */

        System.out.println("==============================");
        System.out.println("CREATE BOOTCAMP");
        System.out.println("==============================");

        Map<String, Object> createRequest = new HashMap<>();
        Map<String, Object> createVariables = new HashMap<>();

        createVariables.put(
                "input",
                BootcampDataBuilder.createInput()
        );

        createRequest.put(
                "query",
                BootcampBodies.createBootcampQuery()
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

        bootcampId = createResponse.jsonPath()
                .getString("data.createBootcamp.id");

        Assert.assertNotNull(bootcampId);

        System.out.println("Bootcamp ID : " + bootcampId);

        /*
         * ===========================
         * GET BOOTCAMP
         * ===========================
         */

        System.out.println("==============================");
        System.out.println("GET BOOTCAMP");
        System.out.println("==============================");

        Map<String, Object> getRequest = new HashMap<>();
        Map<String, Object> getVariables = new HashMap<>();

        getVariables.put("id", bootcampId);

        getRequest.put(
                "query",
                BootcampBodies.getBootcampQuery()
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
                bootcampId,
                getResponse.jsonPath()
                        .getString("data.bootcampById.id")
        );

        /*
         * ===========================
         * UPDATE BOOTCAMP
         * ===========================
         */

        System.out.println("==============================");
        System.out.println("UPDATE BOOTCAMP");
        System.out.println("==============================");

        Map<String, Object> updateRequest = new HashMap<>();
        Map<String, Object> updateVariables = new HashMap<>();

        updateVariables.put("id", bootcampId);

        updateVariables.put(
                "input",
                BootcampDataBuilder.updateInput()
        );

        updateRequest.put(
                "query",
                BootcampBodies.updateBootcampQuery()
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
                bootcampId,
                updateResponse.jsonPath()
                        .getString("data.updateBootcamp.id")
        );

        /*
         * ===========================
         * DELETE BOOTCAMP
         * ===========================
         */

        System.out.println("==============================");
        System.out.println("DELETE BOOTCAMP");
        System.out.println("==============================");

        Map<String, Object> deleteRequest = new HashMap<>();
        Map<String, Object> deleteVariables = new HashMap<>();

        deleteVariables.put("id", bootcampId);

        deleteRequest.put(
                "query",
                BootcampBodies.deleteBootcampQuery()
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

        Assert.assertEquals(
                bootcampId,
                deleteResponse.jsonPath()
                        .getString("data.deleteBootcamp.id")
        );

        System.out.println("==============================");
        System.out.println("BOOTCAMP CRUD SUCCESS");
        System.out.println("==============================");

    }

}