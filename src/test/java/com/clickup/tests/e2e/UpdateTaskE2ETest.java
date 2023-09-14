package com.clickup.tests.e2e;

import com.clickup.dto.CreateTaskRequestDto;
import com.clickup.requests.*;
import io.restassured.path.json.JsonPath;
import org.assertj.core.api.Assertions;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

class UpdateTaskE2ETest {

    private static final Logger LOGGER = LoggerFactory.getLogger(UpdateTaskE2ETest.class);
    private static String spaceName = "e2e java";
    private static String listName = "to do tasks";
    private static String taskName = "Task 1 clickup - wysłane z javy";
    private String spaceId;
    private String listId;
    private String taskId;


    @Test
    void updateTaskE2ETest() {
    spaceId = createSpaceStep();
//    LOGGER.info("Space created with Id: {}", spaceId);

    listId = createListStep();
//    LOGGER.info("List created with id: {}", listId);

    taskId = createTaskStep();
//    LOGGER.info("Task created with id: {}", taskId);

    updateTaskStep();
    closeTaskStep();
    deleteSpaceStep();
    }

    private String createSpaceStep() {
        JSONObject json = new JSONObject();
        json.put("name", spaceName);

        final var response = CreateSpaceRequest.createSpace(json);

        Assertions.assertThat(response.getStatusCode()).isEqualTo(200);

        JsonPath jsonData = response.jsonPath();
        Assertions.assertThat(jsonData.getString("name")).isEqualTo(spaceName);

        return jsonData.getString("id");
    }

    private String createListStep() {
        JSONObject json = new JSONObject();
        json.put("name", listName);
        json.put("spaceId", spaceId);

        final var response = CreateListRequest.createList(json, spaceId);

        Assertions.assertThat(response.getStatusCode()).isEqualTo(200);

        JsonPath jsonData = response.jsonPath();
        Assertions.assertThat(jsonData.getString("name")).isEqualTo(listName);

        return jsonData.getString("id");
    }

    private String createTaskStep() {

//      Pierwotna forma (przed dto)
//        JSONObject task = new JSONObject();
//        task.put("name", taskName);
//        task.put("description", "Opis pierwszego zadania wysłanego z api");
//        task.put("assignees", JSONObject.NULL);
//        task.put("status", "to do");
//        task.put("priority", JSONObject.NULL);
//        task.put("time_estimate", JSONObject.NULL);
//        task.put("parent", JSONObject.NULL);
//        task.put("archived", false);

        CreateTaskRequestDto taskDto = new CreateTaskRequestDto();
        taskDto.setName(taskName);
        taskDto.setDescription("Opis pierwszego zadania wysłanego z api");
        taskDto.setStatus("to do");

//        final var response = CreateTaskRequest.createTask(taskDto,listId);
//        Assertions.assertThat(response.getStatusCode()).isEqualTo(200);
//        JsonPath jsonData = response.jsonPath();
//        Assertions.assertThat(jsonData.getString("name")).isEqualTo(taskName);
//
//        return jsonData.getString("id");
//
//        Przed deserializacją
        final var response = CreateTaskRequest.createTask(taskDto,listId);
        Assertions.assertThat(response.getName()).isEqualTo(taskName);
        Assertions.assertThat(response.getDescription()).isEqualTo("Opis pierwszego zadania wysłanego z api");

        return response.getId();
    }

    private void updateTaskStep() {
        JSONObject updateTask = new JSONObject();
        updateTask.put("name", "Update put - java");
        updateTask.put("description", "Updated - Opis drugiego zadania wysłanego z api");

        final var response = UpdateTaskRequest.updateTask(updateTask, taskId);
        Assertions.assertThat(response.statusCode()).isEqualTo(200);
        JsonPath jsonData = response.jsonPath();
        Assertions.assertThat(jsonData.getString("name")).isEqualTo("Update put - java");
        Assertions.assertThat(jsonData.getString("description")).isEqualTo("Updated - Opis drugiego zadania wysłanego z api");

    }

    private void closeTaskStep() {
        JSONObject closeTask = new JSONObject();
        closeTask.put("status", "complete");

        final var response = UpdateTaskRequest.updateTask(closeTask, taskId);
        Assertions.assertThat(response.statusCode()).isEqualTo(200);
        JsonPath jsonData = response.jsonPath();
        Assertions.assertThat(jsonData.getString("status.status")).isEqualTo("complete");
    }

    private void deleteSpaceStep() {
        final var response = DeleteSpaceRequest.deleteSpace(spaceId);
        Assertions.assertThat(response.getStatusCode()).isEqualTo(200);
    }
}
