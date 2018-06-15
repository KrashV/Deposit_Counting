package com.openway;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArgumentParser {
    static private final List<String> flags = Arrays.asList("-initial", "-apr", "-multiplicity");

    /**
     * Fetches the expected arguments from the commandline
     *
     * @param args initial commandline arguments
     * @return map consisting of values to operate with
     * @throws IllegalArgumentException wrong data format
     */
    public static Map<String, Double> parse(String[] args) throws IllegalArgumentException {
        int argc = args.length;
        Map<String, Double> argMap = new HashMap<>();

        if (argc != flags.size() * 2)
            throw new IllegalArgumentException("Not enough arguments.");

        try {
            for (int i = 0; i < argc; i++) {
                if (flags.contains(args[i])) {
                    if (i >= argc) throw new IllegalArgumentException("Illegal command arguments.");
                    else argMap.put(args[i], Double.parseDouble(args[i + 1]));
                }
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("All values must be numerical.");
        }

        if (argMap.size() != flags.size())
            throw new IllegalArgumentException("Illegal command arguments.");

        return argMap;
    }

    /**
     * Checks whether the arguments are valid to proceed with
     * @param  arguments                the map consisting already fetched values
     * @throws IllegalArgumentException wrong data format
     */
    public static void check(Map<String, Double> arguments) throws IllegalArgumentException {
        Double initial = arguments.get(flags.get(0));
        Double apr = arguments.get(flags.get(1));
        Double multiplicity = arguments.get(flags.get(2));

        // every parameter must be positive
        if (initial < 0 | apr < 0 | multiplicity < 0 )
            throw new IllegalArgumentException("Every parameter must be positive");

        // multiplicity must be greater than one
        if (multiplicity < 1)
            throw new IllegalArgumentException("Multiplicity must be greater than one");

        // finally, APR must be greater than one as well
        if (apr < 1)
            throw new IllegalArgumentException("Annual percentage rate must be greater than one");
    }
}
