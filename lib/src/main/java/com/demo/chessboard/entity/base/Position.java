package com.demo.chessboard.entity.base;

import com.demo.chessboard.enums.File;
import com.demo.chessboard.enums.Rank;
import lombok.Builder;

@Builder
public record Position(Rank rank, File file) {

    @Override
    public String toString() {
        return String.format("%s%d", rank.toString(), file.toString());
    }
}
