package com.example.extensions;

import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.ExecutionCondition;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.platform.commons.support.AnnotationSupport;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.jupiter.api.extension.ConditionEvaluationResult.disabled;
import static org.junit.jupiter.api.extension.ConditionEvaluationResult.enabled;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@ExtendWith(DisabledOnWeekdays.Extension.class)
public @interface DisabledOnWeekdays {

    DayOfWeek[] value();

    class Extension implements ExecutionCondition {
        @Override
        public ConditionEvaluationResult evaluateExecutionCondition(ExtensionContext context) {
            DayOfWeek currentWeekDay = LocalDate.now().getDayOfWeek();
            return AnnotationSupport.findAnnotation(context.getElement(), DisabledOnWeekdays.class)
                .map(DisabledOnWeekdays::value)
                .map(Arrays::asList)
                .filter(weekdays -> weekdays.contains(currentWeekDay))
                .map(__ -> disabled("Today is " + currentWeekDay))
                .orElseGet(() -> enabled(null));
        }
    }
}
