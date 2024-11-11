package com.demo.chessboard.utils;

import com.demo.chessboard.entity.base.Position;
import com.demo.chessboard.enums.File;
import com.demo.chessboard.enums.Rank;

public class PositionHelper {

    private PositionHelper() {
        throw new IllegalStateException("Utility class");
    }

    public static Position parsePosition(String positionCode) {
        File file = File.toFile(positionCode.charAt(0));
        Rank rank = Rank.toRank(Character.getNumericValue(positionCode.charAt(1)));
        return new Position(file, rank);
    }
}
