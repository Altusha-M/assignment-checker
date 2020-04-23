package com.altynov.testchecker.model;

import lombok.Data;

/**
 * Result of test checking
 */
@Data
public class TaskResult {

    private static Long resultCounter = 0L;

    public TaskResult(){
        setId();
    }

    private String idResult;

    private boolean value;

    private Task task;

    private String explanation;

    void setId(){
        idResult = String.valueOf(resultCounter++);
    }

}
