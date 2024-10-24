package com.demo.chessboard.exceptions;

public class InvalidInputFormatException extends RuntimeException {
    public InvalidInputFormatException(String input) {
        super("Invalid input format: " + input);
    }
}
