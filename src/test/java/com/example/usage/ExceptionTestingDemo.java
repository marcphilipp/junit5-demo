package com.example.usage;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ExceptionTestingDemo {

    @Test
    public void newApproach() throws Exception {
        NumberFormatException expected = assertThrows(NumberFormatException.class, () -> {
            Integer.parseInt("foo");
        });
        assertEquals("For input string: \"foo\"", expected.getMessage());
    }
}
