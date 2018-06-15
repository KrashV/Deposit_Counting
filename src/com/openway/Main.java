package com.openway;

import java.util.Map;

public class Main {

    public static void main(String[] args) {
        final String usageHelp = "Usage: -initial <Initial Sum> -apr <Annual Percentage Rate>" +
                " -multiplicity <Multiplicity>";
        final String pattern = "Under the %.2f annual percentage rate," +
                " the initial sum: %.2f will increase by %.1f times in approximately %.4f years.";
        try {
            // Parse the commandline arguments
            Map<String, Double> arguments = ArgumentParser.parse(args);
            // Check whether they're valid
            ArgumentParser.check(arguments);

            // Retrieve the arguments
            Double initialSum = arguments.get("-initial");
            Double apr = arguments.get("-apr");
            Double multiplicity = arguments.get("-multiplicity");

            // Set up the calculator
            DepositCalculator depositCalculator = new DepositCalculator(initialSum,
                    apr, multiplicity);

            // Calculate
            Double result = depositCalculator.calculate();

            // Print the result
            System.out.println(String.format(pattern, apr,
                    initialSum, multiplicity, result));
        } catch (Exception e) {
            // Print the error message
            System.out.println(e.getMessage());
            // Print the usage help
            System.out.println(usageHelp);
        }
    }
}
