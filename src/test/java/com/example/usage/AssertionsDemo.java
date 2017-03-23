package com.example.usage;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ErrorCollector;

public class AssertionsDemo {

    @Test
    public void basicAssertions() {
        assertEquals(2, 1 + 1);
        assertEquals(2, 1 + 1, () -> "1 + 1 = 2");
        assertNull(null);
        assertNotNull(this);
        assertSame("foo", "foo");
        assertArrayEquals(new int[] { 1, 2, 3 }, new int[] { 1, 2, 3 });
    }

    @Test
    public void hamcrestAssertions() {
        assertThat("some text", allOf(notNullValue(), containsString("x")));
    }

    @Test
    public void multipleFailures() {
        assertAll(
                () -> assertThat("foo", is(nullValue())),
                () -> assertThat("foo", is(sameInstance("bar")))
        );
    }

}
