package org.binomial.distribution.core;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

record ExponentCharacter(int number) {

    private static final Map<Integer, Character> EXPONENT_NUMBERS = Map.of(
            0, '\u2070',
            1, '\u00B9',
            2, '\u00B2',
            3, '\u00B3',
            4, '\u2074',
            5, '\u2075',
            6, '\u2076',
            7, '\u2077',
            8, '\u2078',
            9, '\u2079'
    );

    @Override
    public String toString() {
        String sign = number < 0 ? "\u207B" : "";
        String converted = Arrays.stream(Integer.toString(Math.abs(number)).split(""))
                .map(Integer::parseInt)
                .map(EXPONENT_NUMBERS::get)
                .map(String::valueOf)
                .collect(Collectors.joining());
        return sign + converted;
    }
}
