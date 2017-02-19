package com.example.extensions;

import static java.time.DayOfWeek.MONDAY;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class ConditionalDemo {

    @Test
    @DisabledOnMondays
    void conditionalTest() {
        assertNotEquals(MONDAY, LocalDate.now().getDayOfWeek());
    }
}
