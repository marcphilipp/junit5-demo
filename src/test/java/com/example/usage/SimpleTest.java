package com.example.usage;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SimpleTest {

    @Test
    @DisplayName("1 + 1 = 2")
    void myFirstTest() {
        assertEquals(2, 1 + 1);
    }

    @Test
    @Disabled("for some reason")
    void anotherTest() {
        assertEquals(0, 1 + 1);
    }
}
