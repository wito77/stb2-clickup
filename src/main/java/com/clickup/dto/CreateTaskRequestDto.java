package com.clickup.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateTaskRequestDto {

    private String name;
    private String description;
    private String assignees;
    private String status;
    private String priority;
    private String timeEstimate;
    private String parent;
    private boolean archived;

//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public String getAssignees() {
//        return assignees;
//    }
//
//    public void setAssignees(String assignees) {
//        this.assignees = assignees;
//    }
//
//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }
//
//    public String getPriority() {
//        return priority;
//    }
//
//    public void setPriority(String priority) {
//        this.priority = priority;
//    }
//
//    public String getTimeEstimate() {
//        return timeEstimate;
//    }
//
//    public void setTimeEstimate(String timeEstimate) {
//        this.timeEstimate = timeEstimate;
//    }
//
//    public String getParent() {
//        return parent;
//    }
//
//    public void setParent(String parent) {
//        this.parent = parent;
//    }
//
//    public boolean isArchived() {
//        return archived;
//    }
//
//    public void setArchived(boolean archived) {
//        this.archived = archived;
//    }
//
//    @Override
//    public String toString() {
//        return "CreateTaskRequestDto{" +
//                "name='" + name + '\'' +
//                ", description='" + description + '\'' +
//                ", assignees='" + assignees + '\'' +
//                ", status='" + status + '\'' +
//                ", priority='" + priority + '\'' +
//                ", timeEstimate='" + timeEstimate + '\'' +
//                ", parent='" + parent + '\'' +
//                ", archived=" + archived +
//                '}';
//    }
}
