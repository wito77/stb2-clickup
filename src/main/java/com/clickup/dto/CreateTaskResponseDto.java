package com.clickup.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateTaskResponseDto {

    private String id;
    private String name;
    private String description;
    @JsonProperty("text_content")
    private String textContent;
    private CreateTaskStatusDto status;
    private CreateTaskCreatorDto creator;

//    public String getId() {
//        return id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public String getTextContent() {
//        return textContent;
//    }
//
//    public CreateTaskStatusDto getStatus() {
//        return status;
//    }
//
//    public CreateTaskCreatorDto getCreator() {
//        return creator;
//    }
//
//    @Override
//    public String toString() {
//        return "CreateTaskResponseDto{" +
//                "id='" + id + '\'' +
//                ", name='" + name + '\'' +
//                ", description='" + description + '\'' +
//                ", textContent='" + textContent + '\'' +
//                ", status=" + status +
//                ", creator=" + creator +
//                '}';
//    }
}
