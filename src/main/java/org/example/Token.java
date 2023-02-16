package org.example;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Token {

    private final static int FIRST_CHAR_NUMBER = 33;
    private final static int LAST_CHAR_NUMBER = 122;
    private static final int[] possibleTokenLength = {5, 10, 15};
    private final String value;

    public String getValue() {
        return value;
    }

    public Token(String length) {
        //TODO:Validation class
        int parsedInt = TokenLength.MEDIUM.getLength();

        try {
            parsedInt = Integer.parseInt(length);
        } catch (Exception e) {
            e.printStackTrace();
        }

        int finalParsedInt = parsedInt;

        this.value = generateToken(
                Arrays.stream(Arrays.stream(possibleTokenLength).toArray())
                        .anyMatch(x -> x == finalParsedInt) ?
                        parsedInt : TokenLength.MEDIUM.getLength());
    }

    private static String generateToken(int length) {
        StringBuilder token = new StringBuilder();
        for (int i = 0; i < length; i++) {
            token.append(
                    asciToStringConverter(ThreadLocalRandom.current().nextInt(FIRST_CHAR_NUMBER, LAST_CHAR_NUMBER + 1))
            );
        }
        return token.toString();
    }

    private static String asciToStringConverter(int asciNumber) {
        return String.valueOf((char) asciNumber);
    }
}