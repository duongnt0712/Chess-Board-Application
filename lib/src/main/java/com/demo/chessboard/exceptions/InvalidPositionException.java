package com.demo.chessboard.exceptions;

import com.demo.chessboard.entity.base.Position;

public class InvalidPositionException extends RuntimeException {
    public InvalidPositionException(Position position) {
        super(String.format("Position %s is already occupied.", position.toString()));
    }
}
