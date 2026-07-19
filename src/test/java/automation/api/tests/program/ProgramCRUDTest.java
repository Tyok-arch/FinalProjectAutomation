package automation.api.tests.program;

import automation.api.base.BaseGraphQL;
import automation.api.bodies.program.ProgramBodies;
import automation.api.utils.ProgramDataBuilder;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class ProgramCRUDTest extends BaseGraphQL {

    @Test
    public void programCRUD() {

        login();

        String programId;

        System.out.println("==============================");
        System.out.println("CREATE PROGRAM");
        System.out.println("==============================");

        Map<String, Object> createRequest = new HashMap<>();
        Map<String, Object> createVariables = new HashMap<>();

        createVariables.put(
                "input",
                ProgramDataBuilder.createInput()
        );

        createRequest.put(
                "query",
                ProgramBodies.createProgramQuery()
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

        programId = createResponse.jsonPath()
                .getString("data.createProgram.id");

        Assert.assertNotNull(programId);

        System.out.println("Program ID : " + programId);

        System.out.println("==============================");
        System.out.println("GET PROGRAM");
        System.out.println("==============================");

        Map<String, Object> getRequest = new HashMap<>();
        Map<String, Object> getVariables = new HashMap<>();

        getVariables.put("id", programId);

        getRequest.put(
                "query",
                ProgramBodies.getProgramQuery()
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

        Assert.assertNull(getResponse.jsonPath().get("errors"));

        Assert.assertEquals(
                programId,
                getResponse.jsonPath()
                        .getString("data.programById.id")
        );

        System.out.println("==============================");
        System.out.println("UPDATE PROGRAM");
        System.out.println("==============================");

        Map<String, Object> updateRequest = new HashMap<>();
        Map<String, Object> updateVariables = new HashMap<>();

        updateVariables.put("id", programId);

        updateVariables.put(
                "input",
                ProgramDataBuilder.updateInput()
        );

        updateRequest.put(
                "query",
                ProgramBodies.updateProgramQuery()
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

        Assert.assertEquals(
                programId,
                updateResponse.jsonPath()
                        .getString("data.updateProgram.id")
        );

        System.out.println("==============================");
        System.out.println("DELETE PROGRAM");
        System.out.println("==============================");

        Map<String, Object> deleteRequest = new HashMap<>();
        Map<String, Object> deleteVariables = new HashMap<>();

        deleteVariables.put("id", programId);

        deleteRequest.put(
                "query",
                ProgramBodies.deleteProgramQuery()
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

        Assert.assertTrue(
                deleteResponse.jsonPath()
                        .getBoolean("data.deleteProgram")
        );

        System.out.println("==============================");
        System.out.println("PROGRAM CRUD SUCCESS");
        System.out.println("==============================");

    }

}