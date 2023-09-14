package com.clickup.requests;

import com.clickup.properties.ClickupProperties;
import com.clickup.url.ClickupUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;

public class CreateSpaceRequest {

    public static Response createSpace(JSONObject space) {
        return given()
                .spec(BaseRequest.requestSpecWithLogs())
                .body(space.toString())
                .when()
                .post(ClickupUrl.getSpacesUrl(ClickupProperties.getTeamId()))
                .then()
                .log().ifError()
                .extract()
                .response();
    }
}
