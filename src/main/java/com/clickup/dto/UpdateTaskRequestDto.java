package com.clickup.dto;

import lombok.Data;

@Data
public class UpdateTaskRequestDto {
    private String name;
    private String description;
    private String assignees;
    private String status;
    private String priority;
    private String timeEstimate;
    private String parent;
    private boolean archived;
}
