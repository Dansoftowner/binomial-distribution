package org.binomial.distribution.core;

import static java.lang.Math.pow;
import static org.binomial.distribution.core.Combinatorics.ncr;

record BinomialCoefficient(int s, int n, int k) {

    public int absValue() {
        return ncr(n, k);
    }

    @Override
    public String toString() {
        return getPrefix() + getValueAsString();
    }

    private String getValueAsString() {
        int value = absValue();
        if (value == 1 && n != 0)
            return "";
        return Integer.toString(value);
    }

    private String getPrefix() {
        if (k == 0) return "";
        if (pow(s, k) > 0) return "+";
        return "-";
    }
}
