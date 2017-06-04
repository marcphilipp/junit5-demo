package com.example.usage;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Base64;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ParameterizedDemo {

    @ParameterizedTest(name = "base64({0}) = {1}")
    @CsvSource(value = {"foo → Zm9v", "bar → YmFy"}, delimiter = '→')
    void encodingReturnsExpectedOutput(String input, String base64Output) {
        Base64.Encoder encoder = Base64.getEncoder();
        assertEquals(base64Output, encoder.encodeToString(input.getBytes()));
    }

}
