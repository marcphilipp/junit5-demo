package com.example.usage;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

class TagsDemo {

    @Test
    @Tag("integration")
    @Tag("slow")
    void integrationTest(TestInfo testInfo) {
        System.out.println(testInfo.getTags());
    }

}
