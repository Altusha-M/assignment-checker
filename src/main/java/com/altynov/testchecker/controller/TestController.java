package com.altynov.testchecker.controller;

import com.altynov.testchecker.service.TestService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class TestController {

    TestService testService;

    TestController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping(path = "api/check")
    public List<String> check(
                        @RequestBody MyClass body){
        List<String> answer = Arrays.asList(body.getAnswer().split("[;]"));
        List<String> solution = Arrays.asList(body.getSolution().split("[;]"));
        List<String> explanation = Arrays.asList(body.getExplanation().split("[;]"));
        return testService.checkTest(answer, solution, explanation);
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    static class MyClass {
        String answer;
        String solution;
        String explanation;
    }

}
