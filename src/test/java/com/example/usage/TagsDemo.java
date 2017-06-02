package com.example.usage;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TagsDemo {

    @Test
    @Tag("integration")
    @Tag("slow")
    void integrationTest() {
        // test something
    }
}
