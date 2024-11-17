package com.demo.chessboard.enums;

import com.demo.chessboard.exceptions.InvalidRankException;

public enum Rank {
    R1(1),
    R2(2),
    R3(3),
    R4(4),
    R5(5),
    R6(6),
    R7(7),
    R8(8);

    private final int value;

    Rank(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    public static Rank toRank(int value) {
        for (Rank rank : Rank.values()) {
            if (rank.getValue() == value) {
                return rank;
            }
        }
        throw new InvalidRankException(value);
    }

    public static Rank moveForward(Rank rank, int steps) {
        return Rank.toRank(rank.getValue() + steps);
    }

    public static Rank moveBackward(Rank rank, int steps) {
        return Rank.toRank(rank.getValue() - steps);
    }

}
