package com.demo.chessboard.entity.base;

import lombok.Builder;

@Builder
public record Position(char column, int row) {

    @Override
    public String toString() {
        return String.format("%s%d", column, row);
    }
}
