package com.example.usage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.MethodOrderer.Random;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("A list")
@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(Random.class)
@DisplayNameGeneration(ReplaceUnderscores.class)
class ListTests {

    private List<String> list;

    @BeforeEach
    void createNewList() {
        list = new ArrayList<>();
    }

    @Test
    @DisplayName("contains previously added element")
    @Tag("happy-path")
    void addingAnElement() {
        list.add("foo");

        assertEquals("foo", list.get(0));
    }

    @Test
    @Tag("edge-case")
    void cannot_remove_elements_when_empty() {
        var exception = assertThrows(IndexOutOfBoundsException.class,
                () -> list.remove(0));
        assertNotNull(exception.getMessage());
    }
}
