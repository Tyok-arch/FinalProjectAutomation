package automation.api.tests.announcement;

import automation.api.base.BaseGraphQL;
import automation.api.bodies.announcement.AnnouncementBodies;
import automation.api.utils.AnnouncementDataBuilder;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class AnnouncementCRUDTest extends BaseGraphQL {

    @Test
    public void announcementCRUD() {

        login();

        String announcementId;

        /*
         * ===========================
         * CREATE ANNOUNCEMENT
         * ===========================
         */

        System.out.println("==============================");
        System.out.println("CREATE ANNOUNCEMENT");
        System.out.println("==============================");

        Map<String, Object> createRequest = new HashMap<>();
        Map<String, Object> createVariables = new HashMap<>();

        createVariables.put(
                "input",
                AnnouncementDataBuilder.createInput()
        );

        createRequest.put(
                "query",
                AnnouncementBodies.createAnnouncementQuery()
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

        announcementId = createResponse.jsonPath()
                .getString("data.createAnnouncement.id");

        Assert.assertNotNull(announcementId);

        System.out.println("Announcement ID : " + announcementId);

        /*
         * ===========================
         * GET ANNOUNCEMENT
         * ===========================
         */

        System.out.println("==============================");
        System.out.println("GET ANNOUNCEMENT");
        System.out.println("==============================");

        Map<String, Object> getRequest = new HashMap<>();
        Map<String, Object> getVariables = new HashMap<>();

        getVariables.put("id", announcementId);

        getRequest.put(
                "query",
                AnnouncementBodies.getAnnouncementQuery()
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
                announcementId,
                getResponse.jsonPath()
                        .getString("data.announcementById.id")
        );

        /*
         * ===========================
         * UPDATE ANNOUNCEMENT
         * ===========================
         */

        System.out.println("==============================");
        System.out.println("UPDATE ANNOUNCEMENT");
        System.out.println("==============================");

        Map<String, Object> updateRequest = new HashMap<>();
        Map<String, Object> updateVariables = new HashMap<>();

        updateVariables.put("id", announcementId);

        updateVariables.put(
                "input",
                AnnouncementDataBuilder.updateInput()
        );

        updateRequest.put(
                "query",
                AnnouncementBodies.updateAnnouncementQuery()
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
                announcementId,
                updateResponse.jsonPath()
                        .getString("data.updateAnnouncement.id")
        );

        System.out.println("==============================");
        System.out.println("ANNOUNCEMENT CRUD SUCCESS");
        System.out.println("==============================");

    }

}