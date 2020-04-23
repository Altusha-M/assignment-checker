package com.altynov.testchecker.model;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * One test with tasks
 */
@Data
public class Assignment {

    private String id;

    private String name;

    private Part part;

    private List<Task> tasks;

    public void addTask(Task task) {
        tasks.add(task);
    }

}
