package org.binomial.distribution.core;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class BinomialCoefficientTest {

    @Test
    void shouldHaveNoSign() {
        var underTest = new BinomialCoefficient(1, 10, 0);
        assertFalse(underTest.toString().startsWith("+"));
    }

    @ParameterizedTest
    @ValueSource(ints = { 1, -1 })
    void shouldHaveSign(int s) {
        var underTest = new BinomialCoefficient(s, 10, 3);
        assertTrue(underTest.toString().startsWith(s < 0 ? "-" : "+"));
    }

    @Test
    void shouldBeOne() {
        var underTest = new BinomialCoefficient(1, 0, 0);
        assertEquals(underTest.toString(), "1");
    }

    @ParameterizedTest
    @CsvSource({
            "1,4,0",
            "1,4,4",
            "3,3,1",
            "3,3,2",
            "6,4,2"
    })
    void shouldHaveValue(int expected, int n, int k) {
        var underTest = new BinomialCoefficient(1, n, k);
        assertEquals(underTest.absValue(), expected);
    }
}
