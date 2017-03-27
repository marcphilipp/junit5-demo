package com.example.extensions;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

class ConditionalDemo {

    @Test
    @DisabledOnConference
    void conditionalTest() {
        fail("you have to stay in the office today");
    }
}
