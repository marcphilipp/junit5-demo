package com.example.usage;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;
import org.junit.jupiter.api.parallel.Resources;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.parallel.ResourceAccessMode.READ;
import static org.junit.jupiter.api.parallel.ResourceAccessMode.READ_WRITE;
import static org.junit.jupiter.api.parallel.Resources.SYSTEM_PROPERTIES;

class SystemPropertiesTests {

    @BeforeEach
    @AfterEach
    void clearSystemProperty() {
        System.clearProperty("foo");
    }

    @Test
    @ResourceLock(value = SYSTEM_PROPERTIES, mode = READ_WRITE)
    void writeAndRead() {
        System.setProperty("foo", "bar");
        assertEquals("bar", System.getProperty("foo"));
    }

    @Test
    @ResourceLock(value = SYSTEM_PROPERTIES, mode = READ)
    void readOnly() {
        assertNull(System.getProperty("foo"));
    }

}
