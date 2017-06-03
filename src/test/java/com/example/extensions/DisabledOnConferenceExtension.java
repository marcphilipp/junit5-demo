package com.example.extensions;

import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.TestExecutionCondition;
import org.junit.jupiter.api.extension.TestExtensionContext;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class DisabledOnConferenceExtension implements TestExecutionCondition {
    @Override
    public ConditionEvaluationResult evaluate(TestExtensionContext context) {
        return LocalDate.now().getDayOfWeek() == DayOfWeek.FRIDAY
                ? ConditionEvaluationResult.disabled("You're at JetBrains")
                : ConditionEvaluationResult.enabled("Get some work done!!!");
    }
}
