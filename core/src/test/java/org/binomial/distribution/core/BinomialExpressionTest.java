package org.binomial.distribution.core;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinomialExpressionTest {

    @ParameterizedTest
    @CsvSource({
            "a,b,a+b",
            "c,d,c+d",
            "k,q,k+q",
            "x,y,x+y"
    })
    void testVariableNames(String a, String b, String expected) {
        var underTest = new BinomialExpression(a, b, 1, 1);
        assertEquals(expected, underTest.toString());
    }

    void testDistribution(int operand, int exponent) {
        var underTest = new BinomialExpression("a", "b", operand, exponent);
    }
}
