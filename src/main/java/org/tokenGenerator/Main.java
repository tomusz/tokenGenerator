package org.tokenGenerator;

public class Main {
    public static void main(String[] args) {
        Token token = new Token(UserInputProvider.getScannerInput());
        System.out.println(Token.getTokenValueMessage.apply(token));
    }
}