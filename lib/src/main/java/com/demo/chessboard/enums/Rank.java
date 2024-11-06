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

    public static Rank toRank(int value) {
        switch (value) {
            case 1: return R1;
            case 2: return R2;
            case 3: return R3;
            case 4: return R4;
            case 5: return R5;
            case 6: return R6;
            case 7: return R7;
            case 8: return R8;
            default: throw new InvalidRankException(value);
        }
    }
}
