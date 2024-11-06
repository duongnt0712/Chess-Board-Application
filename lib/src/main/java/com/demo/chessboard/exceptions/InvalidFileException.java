package com.demo.chessboard.exceptions;

public class InvalidFileException extends IllegalArgumentException {
    public InvalidFileException() {
        super();
    }

    public InvalidFileException(int value) {
        super(value + " is an invalid file");
    }

    public InvalidFileException(String message) {
        super(message);
    }

    public InvalidFileException(Throwable error) {
        super(error);
    }
}
