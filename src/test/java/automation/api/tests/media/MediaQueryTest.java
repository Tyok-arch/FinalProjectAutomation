package automation.api.tests.media;

import automation.api.base.BaseGraphQL;
import automation.api.bodies.media.MediaBodies;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class MediaQueryTest extends BaseGraphQL {

    @Test
    public void mediaQueryTest() {

        login();

        /*
         * ===========================
         * LIST MEDIAS
         * ===========================
         */

        System.out.println("==============================");
        System.out.println("LIST MEDIAS");
        System.out.println("==============================");

        Map<String, Object> listRequest = new HashMap<>();

        listRequest.put(
                "query",
                MediaBodies.mediasQuery()
        );

        Response listResponse = authRequest()
                .body(listRequest)
                .post();

        listResponse.then().log().all();

        Assert.assertEquals(200, listResponse.statusCode());

        Assert.assertNull(
                listResponse.jsonPath().get("errors")
        );

        /*
         * ===========================
         * COUNT MEDIAS
         * ===========================
         */

        System.out.println("==============================");
        System.out.println("COUNT MEDIAS");
        System.out.println("==============================");

        Map<String, Object> countRequest = new HashMap<>();

        countRequest.put(
                "query",
                MediaBodies.countMediasQuery()
        );

        Response countResponse = authRequest()
                .body(countRequest)
                .post();

        countResponse.then().log().all();

        Assert.assertEquals(200, countResponse.statusCode());

        Assert.assertNull(
                countResponse.jsonPath().get("errors")
        );

        Integer totalMedia = countResponse.jsonPath()
                .getInt("data.countMedias");

        Assert.assertNotNull(totalMedia);

        System.out.println("Total Media : " + totalMedia);

        /*
         * ===========================
         * AVAILABLE STORAGE
         * ===========================
         */

        System.out.println("==============================");
        System.out.println("AVAILABLE STORAGE");
        System.out.println("==============================");

        Map<String, Object> storageRequest = new HashMap<>();

        storageRequest.put(
                "query",
                MediaBodies.availableStorageQuery()
        );

        Response storageResponse = authRequest()
                .body(storageRequest)
                .post();

        storageResponse.then().log().all();

        Assert.assertEquals(200, storageResponse.statusCode());

        Assert.assertNull(
                storageResponse.jsonPath().get("errors")
        );

        Assert.assertNotNull(
                storageResponse.jsonPath()
                        .get("data.availableStorage.max")
        );

        Assert.assertNotNull(
                storageResponse.jsonPath()
                        .get("data.availableStorage.occupied")
        );

        Assert.assertNotNull(
                storageResponse.jsonPath()
                        .get("data.availableStorage.available")
        );

        System.out.println("==============================");
        System.out.println("MEDIA QUERY SUCCESS");
        System.out.println("==============================");

    }

}