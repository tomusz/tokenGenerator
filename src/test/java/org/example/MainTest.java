package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Scanner;

import static org.mockito.Mockito.mock;

public class MainTest {

    private final int LONGEST_INT = 15;
    private final int MEDIUM_AND_DEFAULT_INT = 10;
    private final int SHORTEST_INT = 15;
    private final int FORBIDDEN_INT = 1;
    Scanner scanner = mock(Scanner.class);

    @Test
    public void areCorrectCharactersAreReturnedParametrised() {
        List<ASCITokenRepresentation> asciTokenRepresentationList =
                new ArrayList<>(EnumSet.allOf(ASCITokenRepresentation.class));

        for (ASCITokenRepresentation asciTokenRepresentation : asciTokenRepresentationList) {
            areCorrectCharactersAreReturned(asciTokenRepresentation.getCharNumber(),
                    asciTokenRepresentation.getSign());
        }
    }

    @Test
    public void areCorrectCharactersAreReturned() {
        areCorrectCharactersAreReturned(33, "!");
        areCorrectCharactersAreReturned(35, "#");
        areCorrectCharactersAreReturned(40, "(");
        areCorrectCharactersAreReturned(64, "@");
        areCorrectCharactersAreReturned(97, "a");
        areCorrectCharactersAreReturned(94, "^");
        areCorrectCharactersAreReturned(47, "/");
    }


    @Test
    public void testForLongest() {
        Mockito.when(scanner.nextInt()).thenReturn(LONGEST_INT);
        int tokenLength = Main.generateToken(scanner).length();
        Assertions.assertEquals(tokenLength, LONGEST_INT, "Strings length should match");
    }


    @Test
    public void testForMedium() {
        Mockito.when(scanner.nextInt()).thenReturn(MEDIUM_AND_DEFAULT_INT);
        int tokenLength = Main.generateToken(scanner).length();
        Assertions.assertEquals(tokenLength, MEDIUM_AND_DEFAULT_INT, "Strings length should match");
    }

    @Test
    public void testExpectDefaultValue() {
        Mockito.when(scanner.nextInt()).thenReturn(FORBIDDEN_INT);
        int tokenLength = Main.generateToken(scanner).length();
        Assertions.assertEquals(tokenLength, MEDIUM_AND_DEFAULT_INT, "Strings length should match");
    }

    @Test
    public void testForShort() {
        Mockito.when(scanner.nextInt()).thenReturn(SHORTEST_INT);
        int tokenLength = Main.generateToken(scanner).length();
        Assertions.assertEquals(tokenLength, SHORTEST_INT, "Strings length should match");
    }

    private void areCorrectCharactersAreReturned(int charNumber, String expectedSign) {
        String actualChar = Main.asciToStringConverter(charNumber);
        Assertions.assertEquals(actualChar, expectedSign,
                String.format("Strings should match %s for number %d", expectedSign, charNumber));
    }
}