package com.example.usage;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

public class SimpleTest {

    @Test
    public void myFirstTest() {
        assertEquals(2, 1 + 1);
    }

    @Test
    @Ignore("for some reason")
    public void anotherTest() {
        assertEquals(0, 1 + 1);
    }
}
