package com.example.usage;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ExceptionTestingDemo {

    @Test
    public void oldSchoolApproach() {
        try {
            Integer.parseInt("foo");
            fail("NumberFormatException expected");
        } catch (NumberFormatException expected) {
            assertEquals("For input string: \"foo\"", expected.getMessage());
        }
    }

    @Test(expected = NumberFormatException.class)
    public void annotationParameterApproach() {
        Integer.parseInt("foo");
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void ruleBasedApproach() {
        thrown.expect(NumberFormatException.class);
        thrown.expectMessage("For input string: \"foo\"");

        Integer.parseInt("foo");
    }


    @Test
    public void newApproach() {
        NumberFormatException expected = assertThrows(NumberFormatException.class, () -> {
            Integer.parseInt("bar");
        });
        assertEquals("For input string: \"foo\"", expected.getMessage());
    }

}
