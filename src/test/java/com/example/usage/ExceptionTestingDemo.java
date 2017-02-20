package com.example.usage;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;

public class ExceptionTestingDemo {

    @Test
    public void newApproach() {
        NumberFormatException exception = assertThrows(NumberFormatException.class, () -> {
            Integer.parseInt("foo");
        });
        assertEquals("For input string: \"foo\"", exception.getMessage());
    }


}
