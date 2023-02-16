package org.example;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.example.ASCITokenRepresentation.*;

public class Main {

    static Logger logger = Logger.getLogger(Main.class.getName());
    static int[] possibleTokenLength = {5, 15};

    public static void main(String[] args) {



        Token token = new Token(UserInputProvider.getScannerInput());
        System.out.printf("Token value is %s%n", token.getValue());

        Scanner scanner = new Scanner(System.in);

        logger.log(Level.INFO, "Please provide expected amount of characters for the token.");
        logger.log(Level.INFO, "You can chose 5, 10 or 15 characters. Type 5 for 5 etc.");
        logger.log(Level.INFO, "Providing other range will result in returning default 10 character token");
        logger.log(Level.INFO, String.format("Token is %s", generateToken(scanner)));

    }

    public static String generateToken(Scanner scanner) {
        int parsedInt = TokenLength.MEDIUM.getLength();
        try {
            parsedInt = Integer.parseInt(String.valueOf(scanner.nextInt()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        int finalParsedInt = parsedInt;
        return generateToken(
                Arrays.stream(Arrays.stream(possibleTokenLength).toArray())
                        .anyMatch(x -> x == finalParsedInt) ?
                        parsedInt : TokenLength.MEDIUM.getLength());
    }

    private static String generateToken(int length) {
        StringBuilder token = new StringBuilder();
        for (int i = 0; i < length; i++) {
            token.append(getRandomTokenElement());
        }
        return token.toString();
    }

    private static String getRandomTokenElement() {
        Random random = new Random();
        return switch (random.nextInt(6)) {
            case 0 -> asciToStringConverter(EXCLAMATION_MARK.getCharNumber()); // !
            case 1 -> asciToStringConverter(randomNumberInRange(HASHTAG_MARK.getCharNumber(),
                    AMPERSAND_MARK.getCharNumber())); // #$%&
            case 2 -> asciToStringConverter(randomNumberInRange(OPEN_PARENTHESIS_MARK.getCharNumber(),
                    ASTRIX_MARK.getCharNumber())); // ()*
            case 3 -> asciToStringConverter(randomNumberInRange(EMAIL_MARK.getCharNumber(),
                    UPPER_Z_MARK.getCharNumber())); // @A -Z
            case 4 -> asciToStringConverter(randomNumberInRange(LOWER_A_MARK.getCharNumber(),
                    LOWER_Z_MARK.getCharNumber())); // a- z
            case 5 -> asciToStringConverter(SLASH_MARK.getCharNumber()); // /
            default -> asciToStringConverter(CIRCUMFLEX_MARK.getCharNumber()); //^
        };
    }

    protected static String asciToStringConverter(int asciNumber) {
        return String.valueOf((char) asciNumber);
    }

    private static int randomNumberInRange(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }
}