package org.binomial.distribution.core;

public class BinomialExpression {

    private static final String DEFAULT_VARIABLE_NAME_A = "a";
    private static final String DEFAULT_VARIABLE_NAME_B = "b";

    private final String firstVariableName;
    private final String secondVariableName;
    private final int operand;
    private final int exponent;

    public BinomialExpression(String firstVariableName, String secondVariableName, int operand, int exponent) {
        this.firstVariableName = firstVariableName;
        this.secondVariableName = secondVariableName;
        this.operand = (int)Math.signum(operand);
        this.exponent = validateExponent(exponent);
    }

    public BinomialExpression(int operand, int exponent) {
        this(DEFAULT_VARIABLE_NAME_A, DEFAULT_VARIABLE_NAME_B, operand, exponent);
    }

    public BinomialExpression(int exponent) {
        this(1, exponent);
    }

    private int validateExponent(int n) {
        if (n < 0)
            throw new IllegalArgumentException("Exponent can't be less than 0!");
        return n;
    }

    @Override
    public String toString() {
        return distributedForm();
    }

    public String distributedForm() {
        StringBuilder sb = new StringBuilder();
        for (int k = 0; k <= exponent; k++) {
            sb.append(new BinomialCoefficient(operand, exponent, k))
                    .append(new PoweredMember(firstVariableName, exponent - k))
                    .append(new PoweredMember(secondVariableName, k));
        }
        return sb.toString();
    }
}
