package com.example.usage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("A list")
@TestInstance(Lifecycle.PER_CLASS)
class ListTests {

    private List<Object> list;

    @BeforeEach
    void setUp() {
        list = new ArrayList<>();
    }

    @Test
    @DisplayName("should contain previously added element")
    @Tag("happy-path")
    void addingAnElement() {
        list.add("foo");

        assertEquals("foo", list.get(0));
        assertTrue(list.contains("foo"),
                () -> "list should contain 'foo': " + list);
    }

    @Test
    void removeMissingElement() {
        IndexOutOfBoundsException exception = assertThrows(IndexOutOfBoundsException.class,
                () -> list.remove(0));

        assertTrue(exception.getMessage().contains("0"));
    }
}
