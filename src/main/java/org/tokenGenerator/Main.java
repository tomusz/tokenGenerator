package org.tokenGenerator;

public class Main {
    public static void main(String[] args) {
        Token token = new Token(UserInputProvider.getScannerInput());
        System.out.printf("Token value is %s%n", token.getValue());
    }
}