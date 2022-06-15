package com.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTests {

    @Test
    @DisplayName("subtractTwoNumbers: 2 - 1 = 1")
    void subtractTwoNumbers() {
        Calculator calculator = new Calculator();
        assertEquals(1, calculator.subtract(2, 1), "2 - 1 should equal 1");
    }

    @ParameterizedTest(name = "{0} - {1} = {2}")
    @CsvSource({
            "0,    1,   -1",
            "1,    2,   -1",
            "51,  49,    2",
            "100, 10,   90"
    })
    void subtractParametrizedNumbers(int first, int second, int expectedResult) {
        Calculator calculator = new Calculator();
        assertEquals(expectedResult, calculator.subtract(first, second), () -> first + " + " + second + " should equal " + expectedResult);
    }


    @Test
    @DisplayName("subtractTwoNumbers: 2 + 1 = 3")
    void addTwoNumbers() {
        Calculator calculator = new Calculator();
        assertEquals(3, calculator.add(2, 1), "2 + 1 should equal 3");
    }

    @ParameterizedTest(name = "{0} + {1} = {2}")
    @CsvSource({
            "0,    1,   1",
            "1,    2,   3",
            "51,  49,    100",
            "100, 10,   110"
    })
    void addParametrizedNumbers(int first, int second, int expectedResult) {
        Calculator calculator = new Calculator();
        assertEquals(expectedResult, calculator.add(first, second), () -> first + " + " + second + " should equal " + expectedResult);
    }

}