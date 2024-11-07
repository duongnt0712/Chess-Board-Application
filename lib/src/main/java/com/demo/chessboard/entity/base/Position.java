package com.demo.chessboard.entity.base;

import com.demo.chessboard.enums.File;
import com.demo.chessboard.enums.Rank;
import lombok.Builder;

@Builder(toBuilder = true)
public record Position(File file, Rank rank) {

    @Override
    public String toString() {
        return file.toString() + rank.toString();
    }
}
