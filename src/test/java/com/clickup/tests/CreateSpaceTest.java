package com.clickup.tests;

import com.clickup.requests.CreateSpaceRequest;
import com.clickup.requests.DeleteSpaceRequest;
import com.clickup.requests.UpdateSpaceRequest;
import org.assertj.core.api.Assertions;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

class CreateSpaceTest {

    private static final String SPACE_NAME = "JAVA Test Space";

    @Test
    void createSpaceTest() {

        JSONObject space = new JSONObject();
        space.put("name", SPACE_NAME);

        final var response = CreateSpaceRequest.createSpace(space);

        Assertions.assertThat(response.statusCode()).isEqualTo(200);
        Assertions.assertThat(response.jsonPath().getString("name")).isEqualTo(SPACE_NAME);

        final var spaceId = response.jsonPath().getString("id");

        JSONObject updateSpace = new JSONObject();
        updateSpace.put("name", "Updated Space Name");
        updateSpace.put("color", "#7B68EE");

        final var updateResponse = UpdateSpaceRequest.updateSpace(updateSpace, spaceId);
        Assertions.assertThat(updateResponse.statusCode()).isEqualTo(200);
        Assertions.assertThat(updateResponse.jsonPath().getString("name")).isEqualTo("Updated Space Name");
        Assertions.assertThat(updateResponse.jsonPath().getString("color")).isEqualTo("#7B68EE");


        final var deleteResponse = DeleteSpaceRequest.deleteSpace(spaceId);
        Assertions.assertThat(deleteResponse.statusCode()).isEqualTo(200);

    }
}
