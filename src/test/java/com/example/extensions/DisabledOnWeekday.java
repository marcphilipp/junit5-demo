package com.example.extensions;

import org.junit.jupiter.api.Tag;
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

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@ExtendWith(DisabledOnWeekday.Extension.class)
@Tag("some-tag")
public @interface DisabledOnWeekday {

    DayOfWeek value();

    class Extension implements ExecutionCondition {
        @Override
        public ConditionEvaluationResult evaluateExecutionCondition(ExtensionContext context) {
            return AnnotationSupport.findAnnotation(context.getElement(), DisabledOnWeekday.class)
                    .map(DisabledOnWeekday::value)
                    .filter(dayOfWeek -> LocalDate.now().getDayOfWeek() == dayOfWeek)
                    .map(__ -> ConditionEvaluationResult.disabled("Not today"))
                    .orElseGet(() -> ConditionEvaluationResult.enabled("Get some work done"));
        }
    }
}
