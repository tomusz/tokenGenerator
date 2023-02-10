package org.example;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    static Logger logger = Logger.getLogger(Main.class.getName());
    static int[] possibleTokenLength = {5, 15};

    public static void main(String[] args) {

        // TODO: mock for scanner
        // TODO: test for 5, 10 and 15

        Scanner scanner = new Scanner(System.in);

        logger.log(Level.INFO, "Please provide expected amount of characters for the token.");
        logger.log(Level.INFO, "You can chose 5, 10 or 15 characters. Type 5 for 5 etc.");
        logger.log(Level.INFO, "Providing other range will result in returning default 10 character token");

//        scanner.nextInt();
        int userInput = 10;
        try {
            int parsedInt = Integer.parseInt(String.valueOf(userInput));

            logger.log(Level.INFO,String.format("Token is %s",generateToken(
                    Arrays.stream(Arrays.stream(possibleTokenLength).toArray())
                    .anyMatch(x -> x == parsedInt) ? parsedInt : 10)));




        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static String generateToken(int length) {
        String token = "";
        for (int i=0; i<length; i++) {
            token += getRandomTokenElement();
        }
        return token;
    }

    private static String getRandomTokenElement() {
        Random random = new Random();
        return switch (random.nextInt(6)) {
            case 0 -> asciToStringConverter(33); // !
            case 1 -> asciToStringConverter(randomNumberInRange(35, 38)); // #$%&
            case 2 -> asciToStringConverter(randomNumberInRange(40, 42)); // /()*
            case 3 -> asciToStringConverter(randomNumberInRange(64, 90)); // @A -Z
            case 4 -> asciToStringConverter(randomNumberInRange(97, 122)); // a- z
            default -> asciToStringConverter(94); //^
        };
    }

    private static String asciToStringConverter(int asciNumber) {
        return String.valueOf((char) asciNumber);
    }
    private static int randomNumberInRange(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }
}