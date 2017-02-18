package com.example.usage;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

public class LifecycleDemo {

    @Rule
    public TestName testName = new TestName();

    @BeforeClass
    public static void beforeAll() {
        System.out.println("beforeAll");
    }

    @Before
    public void beforeEach() {
        System.out.println("beforeEach: " + testName.getMethodName() + " in " + this);
    }

    @Test
    public void onePlusOneIsTwo() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void zeroPlusTwoIsTwo() {
        assertEquals(2, 0 + 2);
    }

    @After
    public void afterEach() {
        System.out.println("afterEach: " + testName.getMethodName() + " in " + this);
    }

    @AfterClass
    public static void afterAll() {
        System.out.println("afterAll");
    }
}
