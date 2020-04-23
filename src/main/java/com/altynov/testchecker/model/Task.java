package com.altynov.testchecker.model;


import lombok.Data;

/**
 * Single task of some test
 */
@Data
public class Task {

    private String idTask;

    private String name;

    private String idPart;

    private String idAssignment;

    private String value;

    private String explanation;


}