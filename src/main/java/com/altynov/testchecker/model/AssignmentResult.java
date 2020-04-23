package com.altynov.testchecker.model;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
public class AssignmentResult {

    private String id;

    private List<TaskResult> results;

    private Student student;

}
