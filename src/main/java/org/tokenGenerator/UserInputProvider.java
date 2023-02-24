package org.tokenGenerator;

import java.util.Arrays;
import java.util.Scanner;

public class UserInputProvider {

    public static String getScannerInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(
                """
                        Please provide token length as arithmetic number.
                        Correct values are\s""" + Arrays.toString(Token.getPossibleTokenLength()) + " characters.");
        return scanner.nextLine();
    }
}