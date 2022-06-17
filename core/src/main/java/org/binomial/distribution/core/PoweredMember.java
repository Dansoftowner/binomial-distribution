package org.binomial.distribution.core;

record PoweredMember(String name, int exponent) {
    @Override
    public String toString() {
        return switch (exponent) {
            case 0 -> "";
            case 1 -> name;
            default -> name + new ExponentCharacter(exponent);
        };
    }
}

