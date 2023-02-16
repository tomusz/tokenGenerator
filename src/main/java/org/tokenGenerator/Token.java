package org.tokenGenerator;

import java.util.concurrent.ThreadLocalRandom;

public class Token {

    private final static int FIRST_CHAR_NUMBER = 33;
    private final static int LAST_CHAR_NUMBER = 122;
    private final static int[] possibleTokenLength = {5, 10, 15};
    private String value;

    public Token(String length) {
        int parsedLength = TokenValidation.isValueInteger(possibleTokenLength, length) ? Integer.parseInt(length) : 0;
        if (TokenValidation.isValueInRequiredRange(possibleTokenLength, parsedLength)) {
            this.value = generateToken(parsedLength);
        }
    }

    private static String generateToken(int length) {
        StringBuilder token = new StringBuilder();
        for (int i = 0; i < length; i++) {
            token.append(
                    asciiToStringConverter(ThreadLocalRandom.current().nextInt(FIRST_CHAR_NUMBER, LAST_CHAR_NUMBER + 1))
            );
        }
        return token.toString();
    }

    private static String asciiToStringConverter(int asciiNumber) {
        return String.valueOf((char) asciiNumber);
    }

    public String getValue() {
        return value;
    }
}