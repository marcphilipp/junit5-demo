package com.example.usage;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class ExceptionTestingDemo {

    @Test
    void newApproach() {
        NumberFormatException expected = assertThrows(NumberFormatException.class, () -> {
            Integer.parseInt("foo");
        });
        assertEquals("For input string: \"foo\"", expected.getMessage());
    }

}
