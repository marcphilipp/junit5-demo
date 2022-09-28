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
import java.time.LocalDateTime;
import java.util.Arrays;

import static java.util.function.Predicate.isEqual;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@ExtendWith(DisabledOnWeekdays.Impl.class)
public @interface DisabledOnWeekdays {

    DayOfWeek[] value();

    class Impl implements ExecutionCondition {
        @Override
        public ConditionEvaluationResult evaluateExecutionCondition(ExtensionContext context) {
            return AnnotationSupport.findAnnotation(context.getElement(), DisabledOnWeekdays.class)
                    .map(DisabledOnWeekdays::value)
                    .filter(dayOfWeeks -> Arrays.stream(dayOfWeeks).anyMatch(isEqual(LocalDateTime.now().getDayOfWeek())))
                    .map(__ -> ConditionEvaluationResult.disabled("today is " + LocalDateTime.now().getDayOfWeek()))
                    .orElseGet(() -> ConditionEvaluationResult.enabled("get some work done!"));
        }
    }
}
