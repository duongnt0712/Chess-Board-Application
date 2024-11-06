package com.demo.chessboard.exceptions;

public class InvalidRankException extends IllegalArgumentException {
    public InvalidRankException() {
        super();
    }

    public InvalidRankException(int value) {
        super(value + " is an invalid rank");
    }

    public InvalidRankException(String message) {
        super(message);
    }

    public InvalidRankException(Throwable error) {
        super(error);
    }
}
