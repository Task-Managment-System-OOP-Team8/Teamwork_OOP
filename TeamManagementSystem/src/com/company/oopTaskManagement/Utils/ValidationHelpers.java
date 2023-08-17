package com.company.oopTaskManagement.Utils;

import java.util.List;

public class ValidationHelpers {

    private static final String INVALID_NUMBER_OF_ARGUMENTS = "Invalid number of arguments. " +
            "Expected: %d; received: %d.";
    public static void ValidateIntRange (int current,int min, int max, String errorMessage) {
        if (current < min || current > max) {
            throw new IllegalArgumentException(errorMessage);
        }
    }
    public static void validateArgumentsCount(List<String> list, int expectedNumberOfParameters) {
        if (list.size() < expectedNumberOfParameters) {
            throw new IllegalArgumentException(
                    String.format(INVALID_NUMBER_OF_ARGUMENTS, expectedNumberOfParameters, list.size())
            );
        }
    }
}
