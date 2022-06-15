package com.example;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;

import static org.junit.jupiter.api.Assertions.*;

class AssertSamplesTest {


    @Test
    void testAssertEqualAndNotEquals() {
        String expected = "expected";
        String actual = "expected";
        assertEquals(expected, actual);
        assertNotEquals("not expected", actual);
    }

    @Test
    void testAssertArrayEqual() {
        char[] expected = new char[]{'a', 'b', 'c'};
        char[] actual = "abc".toCharArray();
        assertArrayEquals(expected, actual);
    }

    @Test
    void testAssertNullArrayEqual() {
        char[] expected = null;
        char[] actual = null;
        assertArrayEquals(expected, actual);
    }

    @Test
    void testAssertNullAndNotNull() {
        String nullObject = null;
        String nonNullObject = "nonnull";
        assertNull(nullObject);
        assertNotNull(nonNullObject);
    }

    @Test
    void testAssertSameAndNotSame() {
        Object expectedObject = new Object();
        Object sameObject = expectedObject;
        assertSame(expectedObject, sameObject);
        Object notSameObject = new Object();
        assertNotSame(sameObject, notSameObject);
    }


    @Test
    void testAssertTrueAndFalse() {
        assertTrue(0 < 1);
        assertFalse(1 > 10);
    }

    @Test
    void testAssertIterableEquals() {
        ArrayList<String> listIterable = new ArrayList<>(Arrays.asList("a", "b", "c"));
        LinkedHashSet<String> setIterable = new LinkedHashSet<>(Arrays.asList("a", "b", "c"));
        assertIterableEquals(listIterable, setIterable);

        assertIterableEquals(null, null);
    }


    @Test
    void testAssertAll() {
        assertAll("Sitename",
                () -> assertTrue("Abc".startsWith("A")),
                () -> assertTrue("Abc".endsWith("c")),
                () -> assertEquals(3, "Abc".length())
        );
    }


    @Test
    void testAssertTimeoutNotExceeded() {
        assertTimeout(Duration.ofSeconds(1), () -> "Wont fail as long as the method returns in less than 1 msec");
    }

    @Test
    void testAssertTimeoutFailure() {
        // Fails since the method returns in less than 1 msec
        assertTimeout(Duration.ofSeconds(1), () -> Thread.sleep(2000));
    }


    @Test
    void timeoutExceededWithPreemptiveTermination() {
        // Fails early after 1 milliseconds only: Execution timed out after 1 ms
        assertTimeoutPreemptively(Duration.ofMillis(1), () -> {
            Thread.sleep(5000);
        });
    }


    @Test
    void testAssertThrows() {
        Throwable throwable =
                assertThrows(
                        ArithmeticException.class,
                        () -> {
                            int number = 10 / 0;
                        });
        assertEquals("/ by zero", throwable.getMessage());
    }

    @Test
    void testAssertDoesNotThrow() {
        assertDoesNotThrow(() -> {
        });
    }

    @Test
    void testFail() {
        int returnValue = (int) (Math.random() * 100);
        if (returnValue % 2 == 0) {
            fail("This value should be odd");
        }
    }

}