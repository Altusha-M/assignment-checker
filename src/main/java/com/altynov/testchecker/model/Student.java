package com.altynov.testchecker.model;


import lombok.Data;

import java.util.List;


@Data
public class Student {

    private String idStudent;
    private String name;
    private List<Assignment> assignments;
    private List<AssignmentResult> results;

}
