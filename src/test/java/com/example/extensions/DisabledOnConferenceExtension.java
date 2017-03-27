package com.example.extensions;

import java.time.DayOfWeek;
import java.time.LocalDate;

import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.Extension;
import org.junit.jupiter.api.extension.TestExecutionCondition;
import org.junit.jupiter.api.extension.TestExtensionContext;

public class DisabledOnConferenceExtension implements TestExecutionCondition {
    @Override
    public ConditionEvaluationResult evaluate(TestExtensionContext context) {
        return LocalDate.now().getDayOfWeek() == DayOfWeek.THURSDAY
                ? ConditionEvaluationResult.disabled("You're at a conference")
                : ConditionEvaluationResult.enabled("Get some work done!!!");
    }
}
