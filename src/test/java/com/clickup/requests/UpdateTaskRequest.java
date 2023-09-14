package com.clickup.requests;

import com.clickup.dto.CreateTaskRequestDto;
import com.clickup.dto.CreateTaskResponseDto;
import com.clickup.dto.UpdateTaskRequestDto;
import com.clickup.url.ClickupUrl;
import io.restassured.response.Response;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;

public class UpdateTaskRequest {
    public static Response updateTask(JSONObject updateTask, String taskId) {
        return given()
                .spec(BaseRequest.requestSpecWithLogs())
                .body(updateTask.toString())
                .when()
                .put(ClickupUrl.getTaskUrl(taskId))
                .then()
                .statusCode(200)
                .log().ifError()
                .extract()
                .response();
    }
}
