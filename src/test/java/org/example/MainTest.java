package org.example;

import junitparams.JUnitParamsRunner;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import java.util.Scanner;

import static org.mockito.Mockito.mock;

@RunWith(JUnitParamsRunner.class)
public class MainTest {

    private final int LONGEST_INT = 15;
    private final int MEDIUM_AND_DEFAULT_INT = 10;
    private final int SHORTEST_INT = 15;
    private final int FORBIDDEN_INT = 1;
    Scanner scanner = mock(Scanner.class);

    //TODO:not working yet
//    @Test
//    @Parameters({
//            "33,!",
//            "35,#",
//            "40,/",
//            "64,@",
//            "97,a",
//            "94,^"
//    })
//    public void correctCharactersAreReturned(int charNumber, String expectedSign) {
//        String actualChar = Main.asciToStringConverter(charNumber);
//        Assert.assertEquals("Strings should match", actualChar, expectedSign);
//    }

    @Test
    public void testForLongest() {
        Mockito.when(scanner.nextInt()).thenReturn(LONGEST_INT);
        int tokenLength = Main.generateToken(scanner).length();
        Assert.assertEquals("Strings length should match", tokenLength, LONGEST_INT);
    }


    @Test
    public void testForMedium() {
        Mockito.when(scanner.nextInt()).thenReturn(MEDIUM_AND_DEFAULT_INT);
        int tokenLength = Main.generateToken(scanner).length();
        Assert.assertEquals("Strings length should match", tokenLength, MEDIUM_AND_DEFAULT_INT);
    }

    @Test
    public void testExpectDefaultValue() {
        Mockito.when(scanner.nextInt()).thenReturn(FORBIDDEN_INT);
        int tokenLength = Main.generateToken(scanner).length();
        Assert.assertEquals("Strings length should match", tokenLength, MEDIUM_AND_DEFAULT_INT);
    }

    @Test
    public void testForShort() {
        Mockito.when(scanner.nextInt()).thenReturn(SHORTEST_INT);
        int tokenLength = Main.generateToken(scanner).length();
        Assert.assertEquals("Strings length should match", tokenLength, SHORTEST_INT);
    }
}