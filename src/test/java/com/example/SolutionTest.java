package com.example;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @BeforeAll
    public static void setup2() {
        System.out.println("BeforeAll");
    }

    @AfterAll
    public static void tearDown2() {
        System.out.println("AfterAll");
    }

    @BeforeEach
    void setUp() {
        System.out.println("BeforeEach");
    }

    @AfterEach
    void tearDown() {
        System.out.println("AfterEach");
    }


    @Test
    void givenSmtThenExpectSmt() {
        assertEquals(1,1);
    }
}