package com.openway;

public class DepositCalculator {
    private final Double initialSum, apr, multiplicity;

    DepositCalculator(Double initialSumArg, Double aprArg, Double multiplicityArg) {
        initialSum = initialSumArg;
        apr = aprArg;
        multiplicity = multiplicityArg;
    }

    /**
     * Calculates the estimation time based on given parameters
     *
     * @return time in years
     */
    public Double calculate() {
        /**
         * According to the compound interest formula:
         * I = S * (1 + r) ^ t
         * Under the problem's conditions:
         * I = S * m
         * m = (1 + r) ^ t
         * t = log(m) [base (1 + r)] = ln(m) / ln(1 + r)
         */
        return Math.log(multiplicity) / Math.log(1 + apr / 100);
    }
}
