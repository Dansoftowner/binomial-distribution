package org.binomial.distribution.core;

record BinomialCoefficient(int s, int n, int k) {

    public int value() {
        return (int) Math.pow(Math.signum(s), k) * MathUtils.ncr(n, k);
    }

    @Override
    public String toString() {
        String prefix = k != 0 ? "+" : "";
        String value = Integer.toString(value());
        value = !value.equals("1") ? value : "";
        return prefix + value;
    }
}
