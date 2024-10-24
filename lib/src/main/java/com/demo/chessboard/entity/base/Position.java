package com.demo.chessboard.entity.base;


public record Position(int x, int y) {
    public boolean isValid() {
        return x >= 1 && x <= 8 && y >= 1 && y <= 8;
    }
}
