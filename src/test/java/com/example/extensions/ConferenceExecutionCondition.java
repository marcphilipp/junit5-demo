package com.example.extensions;

import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.ExecutionCondition;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class ConferenceExecutionCondition implements ExecutionCondition {
    @Override
    public ConditionEvaluationResult evaluateExecutionCondition(ExtensionContext context) {
        return LocalDate.now().getDayOfWeek() == DayOfWeek.WEDNESDAY
                ? ConditionEvaluationResult.disabled("you're at W-JAX")
                : ConditionEvaluationResult.enabled("get some work done!");
    }
}
