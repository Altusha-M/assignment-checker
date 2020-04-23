package com.altynov.testchecker.service;

import com.altynov.testchecker.model.Assignment;
import com.altynov.testchecker.model.AssignmentResult;
import com.altynov.testchecker.model.TaskResult;
import com.altynov.testchecker.model.Task;
import com.altynov.testchecker.util.ResultFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TestServiceImpl implements TestService {

    private static final Logger log = LoggerFactory.getLogger(TestServiceImpl.class.getName());

    private static final String MESSAGE_STRING = "Ошибка в № %s: Ожидался ответ: %s получен ответ: %s объяснение: %s";

    AssignmentResult assignmentResult;

//    public TestServiceImpl(AssignmentResult assignmentResult){
//        this.assignmentResult = assignmentResult;
//    }

    @Override
    public AssignmentResult check(Assignment keyAssignment, Assignment answerAssignment) {
        List<Task> keyTests = keyAssignment.getTasks();
        List<Task> studentsTests = answerAssignment.getTasks();
        List<TaskResult> taskResultList = new ArrayList<>();

        for (int i = 0; i < keyTests.size(); i++) {
            Task keyTask = keyTests.get(i);
            Task answerTask = studentsTests.get(i);
            keyTask.getValue().equals(answerTask.getValue());
            TaskResult taskResult = ResultFactory.getResult(answerTask);
            taskResult.setExplanation(keyTask.getExplanation());
            taskResultList.add(taskResult);
        }
        assignmentResult.setResults(taskResultList);

        return assignmentResult;
    }

    @Override
    public List<String> checkTest(List<String> toCheck, List<String> keys, List<String> explanations) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < toCheck.size(); i++) {
            String checkedString = toCheck.get(i);
            String keyString = keys.get(i);

            if (!checkedString.equals(keyString)){
                String res = String.format(MESSAGE_STRING, (i+1), keyString, checkedString, explanations.get(i));
                log.warn(res);
                result.add(res);
            }
        }
        return result;
    }

}