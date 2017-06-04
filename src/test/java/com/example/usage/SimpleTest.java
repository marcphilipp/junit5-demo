package com.example.usage;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SimpleTest {

    @Test
    void myFirstTest() {
        assertEquals(2, 1 + 1);
    }

    @Test
    @Disabled("for some reason")
    void anotherTest() {
        assertEquals(0, 1 + 1);
    }
}
