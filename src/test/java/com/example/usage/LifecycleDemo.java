package com.example.usage;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

class LifecycleDemo {

    @BeforeAll
    static void beforeAll() {
        System.out.println("beforeAll");
    }

    @BeforeEach
    void beforeEach(TestInfo testInfo) {
        System.out.println("beforeEach: " + testInfo.getDisplayName() + " in " + this);
    }

    @Test
    @DisplayName("1 + 1 = 2")
    void onePlusOneIsTwo() {
        assertEquals(2, 1 + 1);
    }

    @Test
    @DisplayName("0 + 2 = 2")
    void zeroPlusTwoIsTwo() {
        assertEquals(2, 0 + 2);
    }

    @AfterEach
    void afterEach(TestInfo testInfo) {
        System.out.println("afterEach: " + testInfo.getDisplayName() + " in " + this);
    }

    @AfterAll
    static void afterAll() {
        System.out.println("afterAll");
    }
}
