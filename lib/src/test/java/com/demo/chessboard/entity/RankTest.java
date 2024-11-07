package com.demo.chessboard.entity;

import com.demo.chessboard.enums.Rank;
import com.demo.chessboard.exceptions.InvalidRankException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RankTest {

    @Test
    void verifyRanks() {
        assertEquals( 8, Rank.values().length, "Unexpected count for Rank");
    }

    @Test
    void shouldEqualToRank() {
        assertEquals( Rank.R1, Rank.toRank(1));
        assertEquals( Rank.R2, Rank.toRank(2));
        assertEquals( Rank.R3, Rank.toRank(3));
        assertEquals( Rank.R4, Rank.toRank(4));
        assertEquals( Rank.R5, Rank.toRank(5));
        assertEquals( Rank.R6, Rank.toRank(6));
        assertEquals( Rank.R7, Rank.toRank(7));
        assertEquals( Rank.R8, Rank.toRank(8));
    }

    @Test
    void shouldReturnInvalidRankException() {
        assertThrows(InvalidRankException.class, () -> Rank.toRank(9));
    }
}
