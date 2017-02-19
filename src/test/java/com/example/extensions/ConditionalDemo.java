package com.example.extensions;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

class ConditionalDemo {

    @Test
    @DisabledOnConference
    void conditionalTest() {
        fail("you have to stay in the office today");
    }
}
