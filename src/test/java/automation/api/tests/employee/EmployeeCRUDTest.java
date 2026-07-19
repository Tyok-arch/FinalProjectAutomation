package automation.api.tests.employee;

import automation.api.base.BaseGraphQL;
import automation.api.bodies.employee.EmployeeBodies;
import automation.api.utils.EmployeeDataBuilder;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class EmployeeCRUDTest extends BaseGraphQL {

    @Test
    public void employeeCRUD() {

        login();

        String employeeId;

        System.out.println("==============================");
        System.out.println("CREATE EMPLOYEE");
        System.out.println("==============================");

        Map<String, Object> createRequest = new HashMap<>();
        Map<String, Object> createVariables = new HashMap<>();

        createVariables.put(
                "input",
                EmployeeDataBuilder.createEmployeeInput()
        );

        createRequest.put(
                "query",
                EmployeeBodies.createEmployeeQuery()
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

        employeeId = createResponse.jsonPath()
                .getString("data.createEmployee.id");

        Assert.assertNotNull(employeeId);

        System.out.println("Employee ID : " + employeeId);

        System.out.println("==============================");
        System.out.println("GET EMPLOYEE");
        System.out.println("==============================");

        Map<String, Object> getRequest = new HashMap<>();
        Map<String, Object> getVariables = new HashMap<>();

        getVariables.put("id", employeeId);

        getRequest.put(
                "query",
                EmployeeBodies.getEmployeeQuery()
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
                employeeId,
                getResponse.jsonPath().getString("data.employeeById.id")
        );

        System.out.println("==============================");
        System.out.println("UPDATE EMPLOYEE");
        System.out.println("==============================");

        Map<String, Object> updateRequest = new HashMap<>();
        Map<String, Object> updateVariables = new HashMap<>();

        updateVariables.put("id", employeeId);

        updateVariables.put(
                "input",
                EmployeeDataBuilder.updateEmployeeInput()
        );

        updateRequest.put(
                "query",
                EmployeeBodies.updateEmployeeQuery()
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

        Assert.assertEquals(
                employeeId,
                updateResponse.jsonPath().getString("data.updateEmployee.id")
        );

        System.out.println("==============================");
        System.out.println("DELETE EMPLOYEE");
        System.out.println("==============================");

        Map<String, Object> deleteRequest = new HashMap<>();
        Map<String, Object> deleteVariables = new HashMap<>();

        deleteVariables.put("id", employeeId);

        deleteRequest.put(
                "query",
                EmployeeBodies.deleteEmployeeQuery()
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
        System.out.println("CRUD SUCCESS");
        System.out.println("==============================");

    }

}