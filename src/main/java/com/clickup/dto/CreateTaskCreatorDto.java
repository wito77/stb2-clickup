package com.clickup.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateTaskCreatorDto {

    @JsonProperty("username")
    private String userName;
    private String email;

//    public String getUsername() {
//        return userName;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    @Override
//    public String toString() {
//        return "CreateTaskCreatorDto{" +
//                "username='" + userName + '\'' +
//                ", email='" + email + '\'' +
//                '}';
//    }
}
