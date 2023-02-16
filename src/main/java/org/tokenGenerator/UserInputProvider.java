package org.tokenGenerator;

import java.util.Scanner;

public class UserInputProvider {

    public static String getScannerInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(
                """
                        Please provide token length as arithmetic number.
                        Correct values are 5, 10 or 15 characters. Type 5 for 5 etc.""");
        return scanner.nextLine();
    }
}