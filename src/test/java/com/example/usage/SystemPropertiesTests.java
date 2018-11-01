package com.example.usage;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class SystemPropertiesTests {

    @BeforeEach
    @AfterEach
    void clearSystemProperty() {
        System.clearProperty("foo");
    }

    @Test
    void writeAndRead() {
        System.setProperty("foo", "bar");
        assertEquals("bar", System.getProperty("foo"));
    }

    @Test
    void readOnly() {
        assertNull(System.getProperty("foo"));
    }

}
