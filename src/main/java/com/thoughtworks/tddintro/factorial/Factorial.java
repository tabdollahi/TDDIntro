package com.thoughtworks.tddintro.factorial;

public class Factorial {
    public Integer compute(int i) {
        if (i < 0){
            throw new IllegalArgumentException("i must be a positive number");
        }
        if (i < 2) {
            return 1;
        }
        return i * compute(i - 1);
    }
}
