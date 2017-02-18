package com.example.usage;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

public class AssertionsDemo {

    @Test
    public void basicAssertions() {
        assertEquals(2, 1 + 1);
        assertEquals("1 + 1 = 2", 2, 1 + 1);
        assertNull(null);
        assertNotNull(this);
        assertSame("foo", "foo");
        assertArrayEquals(new int[] { 1, 2, 3 }, new int[] { 1, 2, 3 });
    }

    @Test
    public void hamcrestAssertions() {
        assertThat("some text", allOf(notNullValue(), containsString("x")));
    }

    @Rule
    public ErrorCollector errorCollector = new ErrorCollector();

    @Test
    public void multipleFailures() {
        errorCollector.checkThat("foo", is(nullValue()));
        errorCollector.checkThat("foo", is(sameInstance("bar")));
    }

}
