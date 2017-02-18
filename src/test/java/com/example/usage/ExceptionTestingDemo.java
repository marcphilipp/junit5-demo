package com.example.usage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

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

}
