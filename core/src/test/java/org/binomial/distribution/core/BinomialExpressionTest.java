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

    @ParameterizedTest
    @CsvSource({
            "a\u00B2+2ab+b\u00B2,1,2",
            "a\u00B2-2ab+b\u00B2,-1,2",
            "a\u00B3+3a\u00B2b+3ab\u00B2+b\u00B3,1,3",
            "a\u00B3-3a\u00B2b+3ab\u00B2-b\u00B3,-1,3",
            "a\u2074+4a\u00B3b+6a\u00B2b\u00B2+4ab\u00B3+b\u2074,1,4",
            "a\u2074-4a\u00B3b+6a\u00B2b\u00B2-4ab\u00B3+b\u2074,-1,4"
    })
    void testDistribution(String expected, int operand, int exponent) {
        var underTest = new BinomialExpression("a", "b", operand, exponent);
        assertEquals(expected, underTest.toString());
    }
}
