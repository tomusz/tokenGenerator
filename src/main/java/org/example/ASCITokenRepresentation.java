package org.example;

public enum ASCITokenRepresentation {

//    case 0 -> asciToStringConverter(33); // !
//            case 1 -> asciToStringConverter(randomNumberInRange(35, 38)); // #$%&
//            case 2 -> asciToStringConverter(randomNumberInRange(40, 42)); // ()*
//            case 3 -> asciToStringConverter(randomNumberInRange(64, 90)); // @A -Z
//            case 4 -> asciToStringConverter(randomNumberInRange(97, 122)); // a- z
//            case 5 -> asciToStringConverter(47); // /
//    default -> asciToStringConverter(94); //^

    EXCLAMATION_MARK(33, "!"),
    HASHTAG_MARK(35, "#"),
    AMPERSAND_MARK(38, "&"),
    OPEN_PARENTHESIS_MARK(40, "("),
    ASTRIX_MARK(42, "*"),
    EMAIL_MARK(64, "@"),
    UPPER_Z_MARK(90, "Z"),
    LOWER_A_MARK(97, "a"),
    LOWER_Z_MARK(122, "z"),
    SLASH_MARK(47, "/"),
    CIRCUMFLEX_MARK(94, "^");

    private final int charNumber;
    private final String sign;

    ASCITokenRepresentation(int charNumber, String sign) {
        this.charNumber = charNumber;
        this.sign = sign;
    }

    public int getCharNumber() {
        return charNumber;
    }

    public String getSign() {
        return sign;
    }
}
