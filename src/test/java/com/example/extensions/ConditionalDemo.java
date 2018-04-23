package com.example.extensions;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

@Disabled("not yet implemented")
class ConditionalDemo {

    @Test
    @DisabledOnConference
    void conditionalTest() {
        fail("you have to stay in the office today");
    }
}
