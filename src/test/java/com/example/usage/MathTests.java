package com.example.usage;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

class MathTests {

    @ParameterizedTest(name = "sqrt({0}) = {1}")
    @CsvSource(textBlock = """
        4, 2
        2, 1.41
        9, 3
    """)
    void sqrt(double input, double expected) {
        assertEquals(expected, Math.sqrt(input), 0.01);
    }

    @RepeatedTest(100)
    void flakyTest() {
        assertEquals(0.0, Math.random(), 0.9);
    }

    @TestFactory
    Stream<DynamicTest> evenNumbersAreDivisibleByTwo() {
        return IntStream.iterate(0, n -> n + 2)
                .limit(1000)
                .mapToObj(i -> dynamicTest(i + " is even", () -> {
                    assertEquals(0, i % 2);
                }));
    }
}
