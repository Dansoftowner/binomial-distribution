package org.binomial.distribution.core;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PoweredMemberTest {

    @ParameterizedTest
    @ValueSource(strings = {"a", "b", "c", "d", "e", "f"})
    void itShouldBeEmpty(String name) {
        var underTest = new PoweredMember(name, 0);
        assertEquals("", underTest.toString());
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "b", "c", "d", "e", "f"})
    void itShouldBeIdentical(String name) {
        var underTest = new PoweredMember(name, 1);
        assertEquals(name, underTest.toString());
    }

    @ParameterizedTest
    @ValueSource(ints = {-2300, -5, -3, -1, 2, 3, 8, 1100})
    void itShouldRaiseIt(int exponent) {
        var underTest = new PoweredMember("a", exponent);
        assertEquals("a" + new ExponentCharacter(exponent), underTest.toString());
    }
}
