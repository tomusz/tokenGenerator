package org.tokenGenerator;

import java.util.Arrays;

public class TokenValidation {

    private static final String ERROR_MESSAGE = "Provided value is not supported. Please use one of values %s";

    public static boolean isValueInteger(int[] requiredRange, String userInput) {
        try {
            Integer.parseInt(userInput);
            return true;
        } catch (NumberFormatException nfe) {
            throw new NumberFormatException(String.format(ERROR_MESSAGE, Arrays.toString(requiredRange)));
        }
    }

    public static boolean isValueInRequiredRange(int[] requiredRange, int userInput) {
        if (Arrays.stream(Arrays.stream(requiredRange).toArray())
                .noneMatch(x -> x == userInput)) {
            throw new IllegalArgumentException(String.format(ERROR_MESSAGE, Arrays.toString(requiredRange)));
        }
        return true;
    }


}