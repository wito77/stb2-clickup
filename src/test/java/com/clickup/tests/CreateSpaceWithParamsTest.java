package com.clickup.tests;

import com.clickup.requests.CreateSpaceRequest;
import com.clickup.requests.DeleteSpaceRequest;
import org.assertj.core.api.Assertions;
import org.json.JSONObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class CreateSpaceWithParamsTest {

    @ParameterizedTest(name ="Create space with name: {0}")
    @DisplayName("Create space with valid space name")
    @MethodSource("createSpaceData")
    void createSpaceTest(String spaceName) {

        JSONObject space = new JSONObject();
        space.put("name", spaceName);

        final var response = CreateSpaceRequest.createSpace(space);

        Assertions.assertThat(response.statusCode()).isEqualTo(200);
        Assertions.assertThat(response.jsonPath().getString("name")).isEqualTo(spaceName);

        final var spaceId = response.jsonPath().getString("id");

        final var deleteResponse = DeleteSpaceRequest.deleteSpace(spaceId);
        Assertions.assertThat(deleteResponse.statusCode()).isEqualTo(200);

    }

    private  static Stream<Arguments> createSpaceData() {
        return Stream.of(
                Arguments.of("SPACE NAME TEST JAVA"),
                Arguments.of("&"),
                Arguments.of("#")
        );
    }
}
