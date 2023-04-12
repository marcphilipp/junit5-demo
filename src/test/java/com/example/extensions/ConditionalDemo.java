package com.example.extensions;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static java.time.DayOfWeek.SUNDAY;
import static org.junit.jupiter.api.Assertions.fail;

@Disabled("not yet implemented")
class ConditionalDemo {

    @Test
    @DisabledOnWeekday(SUNDAY)
    void conditionalTest() {
        fail("fix me");
    }

}
