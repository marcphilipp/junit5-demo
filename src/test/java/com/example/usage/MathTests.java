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

public class MathTests {

    @ParameterizedTest(name = "sqrt({0}) = {1}")
    @CsvSource({
            " 1, 1.00",
            " 2, 1.41",
            " 4, 2.00",
            "16, 4.00"
    })
    void sqrt(double input, double expectedOutput) {
        assertEquals(expectedOutput, Math.sqrt(input), 0.01);
    }

    @RepeatedTest(100)
    void flakyTest() {
        assertEquals(0.0, Math.random(), 0.9);
    }

    @TestFactory
//    @Execution(ExecutionMode.SAME_THREAD)
    Stream<DynamicTest> evenNumberAreEven() {
        return IntStream.iterate(0, n -> n + 2)
                .limit(100)
                .mapToObj(n -> dynamicTest(n + " is even", () -> {
                    assertEquals(0, n % 2);
                    Thread.sleep(1000);
                }));
    }
}
