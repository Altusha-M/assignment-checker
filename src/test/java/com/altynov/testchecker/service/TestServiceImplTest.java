package com.altynov.testchecker.service;

import com.altynov.testchecker.model.Assignment;
import com.altynov.testchecker.model.AssignmentResult;
import com.altynov.testchecker.model.TaskResult;
import com.altynov.testchecker.model.Task;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class TestServiceImplTest {

    @Autowired
    TestService testService;

    private static Assignment keyAssignment = new Assignment();
    private static Task task1 = new Task();
    private static Task task2 = new Task();
    private static Task task3 = new Task();
    private static Task task4 = new Task();
    private static Task task5 = new Task();
    private static Task task6 = new Task();

    private static Assignment studentAssignment = new Assignment();
    private static Task givenTask1 = new Task();
    private static Task givenTask2 = new Task();
    private static Task givenTask3 = new Task();
    private static Task givenTask4 = new Task();
    private static Task givenTask5 = new Task();
    private static Task givenTask6 = new Task();

    @BeforeAll
    static void init(){
        keyAssignment.setTasks(new ArrayList<>());

        task1.setName("task1");
        task2.setName("task2");
        task3.setName("task3");
        task4.setName("task4");
        task5.setName("task5");
        task6.setName("task6");

        task1.setExplanation("because1");
        task2.setExplanation("because2");
        task3.setExplanation("because3");
        task4.setExplanation("because4");
        task5.setExplanation("because5");
        task6.setExplanation("because6");

        task1.setValue("a");
        task2.setValue("b");
        task3.setValue("c");
        task4.setValue("d");
        task5.setValue("e");
        task6.setValue("f");

        keyAssignment.addTask(task1);
        keyAssignment.addTask(task2);
        keyAssignment.addTask(task3);
        keyAssignment.addTask(task4);
        keyAssignment.addTask(task5);
        keyAssignment.addTask(task6);


        givenTask1.setName("task1");
        givenTask2.setName("task2");
        givenTask3.setName("task3");
        givenTask4.setName("task4");
        givenTask5.setName("task5");
        givenTask6.setName("task6");

        givenTask1.setExplanation("because1");
        givenTask2.setExplanation("because2");
        givenTask3.setExplanation("because3");
        givenTask4.setExplanation("because4");
        givenTask5.setExplanation("because5");
        givenTask6.setExplanation("because6");

        givenTask1.setValue("a");
        givenTask2.setValue("b");
        givenTask3.setValue("c");
        givenTask4.setValue("d");
        givenTask5.setValue("e");
        givenTask6.setValue("f");

        studentAssignment.setTasks(new ArrayList<>());
        studentAssignment.addTask(givenTask1);
        studentAssignment.addTask(givenTask2);
        studentAssignment.addTask(givenTask3);
        studentAssignment.addTask(givenTask4);
        studentAssignment.addTask(givenTask5);
        studentAssignment.addTask(givenTask6);

    }

    @Test
    void check() {
        AssignmentResult check = testService.check(keyAssignment, studentAssignment);
        System.out.println(check);
    }

}