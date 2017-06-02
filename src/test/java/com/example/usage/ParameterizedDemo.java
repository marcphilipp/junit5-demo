package com.example.usage;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.Base64;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ParameterizedDemo {

    @Parameters(name = "base64({0}) = {1}")
    public static Iterable<Object[]> parameters() {
        return asList(
                new Object[]{ "foo", "Zm9v" },
                new Object[]{ "bar", "YmFy" }
        );
    }

    @Parameter(0)
    public String input;

    @Parameter(1)
    public String base64Output;

    @Test
    public void encodingAStringReturnsExpectedOutput() {
        Base64.Encoder encoder = Base64.getEncoder();
        assertEquals(base64Output, encoder.encodeToString(input.getBytes()));
    }

}
