package com.javatechie.dto;

import lombok.Data;

@Data
public class TaskDto {
    private String taskId;
    private String description;
    private int severity;
    private String assignee;
    private int storyPoint;

}
