package com.example.usage;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import com.example.categories.Integration;
import com.example.categories.Slow;

public class TagsDemo {

    @Test
    @Category({ Integration.class, Slow.class })
    public void integrationTest() {
        // test something
    }
}
