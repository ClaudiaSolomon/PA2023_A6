package org.example.Lab7;

public class Token {

    private final int number;

    public Token(int number) {
        this.number = number;
    }
    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "Token{" +
                "number=" + number +
                '}';
    }
}

