package com.example.usage;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

@Tag("integration")
class TagsDemo {

    @Test
    @Tag("slow")
    void integrationTest(TestInfo testInfo) {
        // test something
        System.out.println(testInfo.getTags());
    }
}
