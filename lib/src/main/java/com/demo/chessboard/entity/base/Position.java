package com.demo.chessboard.entity.base;

import com.demo.chessboard.enums.File;
import com.demo.chessboard.enums.Rank;
import lombok.Builder;

@Builder
public record Position(File file, Rank rank) {

    @Override
    public String toString() {
        return file.name() + rank.name();
    }
}
