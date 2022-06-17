package org.binomial.distribution.core;

public class Combinatorics {

    private Combinatorics() {
    }

    public static int ncr(int n, int k) {
        return factorial(n) / (factorial(n - k) * factorial(k));
    }

    public static int factorial(int n) {
        return n < 1 ? 1 : n * factorial(n - 1);
    }
}
