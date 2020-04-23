package com.altynov.testchecker.util;

import com.altynov.testchecker.model.TaskResult;
import com.altynov.testchecker.model.Task;

public class ResultFactory {
    public static TaskResult getResult(Task task){
        TaskResult taskResult = new TaskResult();
        taskResult.setTask(task);
        return taskResult;
    }
}
