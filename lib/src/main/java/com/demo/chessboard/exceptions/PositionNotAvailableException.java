package com.demo.chessboard.exceptions;

import com.demo.chessboard.entity.base.Position;

public class PositionNotAvailableException extends RuntimeException {
    public PositionNotAvailableException(Position position) {
        super(String.format("Position %s is already occupied.", position.toString()));
    }
}
