package com.example.extensions;

import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.ExecutionCondition;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.platform.commons.support.AnnotationSupport;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.jupiter.api.extension.ConditionEvaluationResult.disabled;
import static org.junit.jupiter.api.extension.ConditionEvaluationResult.enabled;

class DisabledOnWeekdaysExtension implements ExecutionCondition {
    @Override
    public ConditionEvaluationResult evaluateExecutionCondition(ExtensionContext context) {
        DayOfWeek currentDayOfWeek = LocalDate.now().getDayOfWeek();
        return AnnotationSupport.findAnnotation(context.getElement(), DisabledOnWeekdays.class)
                .map(DisabledOnWeekdays::value)
                .map(Arrays::asList)
                .filter(weekdays -> weekdays.contains(currentDayOfWeek))
                .map(it -> disabled("Disabled because today is " + currentDayOfWeek))
                .orElseGet(() -> enabled(null));
    }
}
