package com.demo.chessboard.utils;

import com.demo.chessboard.entity.base.Position;
import com.demo.chessboard.enums.File;
import com.demo.chessboard.enums.Rank;
import com.demo.chessboard.enums.Side;

public class PositionHelper {

    private PositionHelper() {
        throw new IllegalStateException("Utility class");
    }

    public static Position parsePosition(String positionCode) {
        File file = File.toFile(positionCode.charAt(0));
        Rank rank = Rank.toRank(Character.getNumericValue(positionCode.charAt(1)));
        return new Position(file, rank);
    }

    public static boolean isValidPosition(Position position, int horizontalSteps, int verticalSteps) {
        int newFileValue = position.file().getValue() + horizontalSteps;
        int newRankValue = position.rank().getValue() + verticalSteps;
        return newFileValue >= 1 && newFileValue <= 8 && newRankValue >= 1 && newRankValue <= 8;
    }

    public static Position move(Position position, int horizontalSteps, int verticalSteps) {
        File newFile = File.move(position.file(), horizontalSteps);
        Rank newRank = Rank.move(position.rank(), verticalSteps);
        return new Position(newFile, newRank);
    }

    public static boolean isInitialPosition(Side side, Position position) {
        return (side == Side.WHITE && getRankValue(position) == 2) || (side == Side.BLACK && getRankValue(position) == 7);
    }

    private static int getRankValue(Position position) {
        return position.rank().getValue();
    }
}
