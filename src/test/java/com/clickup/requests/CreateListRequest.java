package com.clickup.requests;

import com.clickup.properties.ClickupProperties;
import com.clickup.url.ClickupUrl;
import io.restassured.response.Response;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;

public class CreateListRequest {

    public static Response createList(JSONObject list, String spaceId) {
        return given()
                .spec(BaseRequest.requestSpecWithLogs())
                .body(list.toString())
                .when()
                .post(ClickupUrl.getListsUrl(spaceId))
                .then()
                .log().ifError()
                .extract()
                .response();
    }
}
