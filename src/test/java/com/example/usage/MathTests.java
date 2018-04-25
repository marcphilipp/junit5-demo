package com.example.usage;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.lang.Math.random;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

public class MathTests {
    @ParameterizedTest(name = "sqrt({0}) = {1}")
    @CsvSource({
            "1, 1.00",
            "2, 1.41",
            "4, 2"
    })
    void sqrt(int input, double expectedValue) {
        assertEquals(expectedValue, Math.sqrt(input), 0.01);
    }

    @RepeatedTest(100)
    void flakyTest() {
        assertEquals(0, random(), 0.9);
    }

    @TestFactory
    Stream<DynamicTest> evenNumbersAreEven() {
        return IntStream.iterate(0, i -> i + 2)
                .limit(100)
                .mapToObj(i -> dynamicTest(i + " is even", () -> {
                    assertEquals(0, i % 2);
                }));
    }
}
