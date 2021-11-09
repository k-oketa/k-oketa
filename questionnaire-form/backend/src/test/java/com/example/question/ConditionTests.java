package com.example.question;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ConditionTests {

    @Test
    void testContain() {
        var conditions = Arrays.asList(new Condition(1, 1), new Condition(1, 2));
        assertTrue(conditions.contains(new Condition(1, 1)));
    }
}
