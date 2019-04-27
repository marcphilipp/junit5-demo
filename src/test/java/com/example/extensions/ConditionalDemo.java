package com.example.extensions;

import org.junit.jupiter.api.Test;

import static java.time.DayOfWeek.SATURDAY;
import static java.time.DayOfWeek.SUNDAY;
import static org.junit.jupiter.api.Assertions.fail;

class ConditionalDemo {

    @Test
    @DisabledOnWeekdays({SATURDAY, SUNDAY})
    void conditionalTest() {
        fail("fix me");
    }

}
