package com.demo.chessboard.exceptions;

public class InvalidSideException extends RuntimeException {
    public InvalidSideException(String side) {
        super("Invalid side: " + side);
    }
}