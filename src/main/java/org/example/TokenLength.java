package org.example;

public enum TokenLength {
    SHORT(5),
    MEDIUM(10),
    LONG(15);

    private int length;

    public int getLength() {
        return length;
    }

    private TokenLength(int length) {
        this.length = length;
    }
}
