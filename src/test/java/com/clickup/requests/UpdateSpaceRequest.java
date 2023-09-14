package com.clickup.requests;

import com.clickup.url.ClickupUrl;
import io.restassured.response.Response;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;

public class UpdateSpaceRequest {
    public static Response updateSpace(JSONObject updateSpace, String spaceId)  {
        return given()
                .spec(BaseRequest.requestSpecWithLogs())
                .body(updateSpace.toString())
                .when()
                .put(ClickupUrl.getSpaceUrl(spaceId))
                .then()
                .statusCode(200)
                .log().ifError()
                .extract()
                .response();
    }
}
