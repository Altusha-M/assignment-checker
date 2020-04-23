package com.altynov.testchecker.service;

import com.altynov.testchecker.model.Assignment;
import com.altynov.testchecker.model.AssignmentResult;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service for tests
 */
@Service
public interface TestService {

    AssignmentResult check(Assignment assignment, Assignment answer);

    List<String> checkTest(List<String> toCheck, List<String> keys, List<String> explanations);

}