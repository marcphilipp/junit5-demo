package com.example.extensions;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static java.time.DayOfWeek.TUESDAY;
import static org.junit.jupiter.api.Assertions.fail;

@Disabled("not yet implemented")
class ConditionalDemo {

    @Test
    @DisabledOnWeekdays(TUESDAY)
    void conditionalTest() {
        fail("fix me");
    }

}
