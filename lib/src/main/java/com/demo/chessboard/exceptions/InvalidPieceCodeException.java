package com.demo.chessboard.exceptions;

public class InvalidPieceCodeException extends RuntimeException {
    public InvalidPieceCodeException(String pieceCode) {
        super("Invalid piece type: " + pieceCode);
    }
}
