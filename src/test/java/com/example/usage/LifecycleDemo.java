package com.example.usage;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;

@TestInstance(PER_CLASS)
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
    void onePlusOneIsTwo() {
        assertEquals(2, 1 + 1);
    }

    @Test
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
