package com.binomial.distribution.cli;

import org.binomial.distribution.core.BinomialExpression;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Consumer;

public class CLIApp {

    private static final String VERSION = "1.0-SNAPSHOT";
    private static final String A = "a";
    private static final String B = "b";

    public static void main(String[] args) {
        printHeader();
        startLooping();
    }

    private static void printHeader() {
        System.out.printf("""
                -------------------------------------------------------
                Binomial Distribution %s
                -------------------------------------------------------
                        
                %n""", VERSION);
    }

    private static void startLooping() {
        try(var reader = new BufferedReader(new InputStreamReader(System.in))) {
            do {
                System.out.printf("(%s+%s)^", A, B);
                readExponent(reader, e -> System.out.println("Invalid number!"), exponent -> {
                    var expression = new BinomialExpression(A, B, 1, exponent);
                    System.out.println(expression);
                });
            } while(!reader.readLine().contains("x"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readExponent(
            BufferedReader reader,
            Consumer<Exception> onFailed,
            Consumer<Integer> onSucceeded
    ) throws IOException {
        String input = reader.readLine();
        try {
            int exponent = Integer.parseInt(input);
            if (exponent < 0) throw new NumberFormatException();
            onSucceeded.accept(exponent);
        } catch (NumberFormatException e) {
            onFailed.accept(e);
        }
    }
}
