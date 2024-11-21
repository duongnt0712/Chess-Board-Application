package com.demo.chessboard.enums;

import com.demo.chessboard.exceptions.InvalidRankException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RankTest {

    @Test
    void verifyRanks() {
        assertEquals( 8, Rank.values().length, "Expected count for Rank is 8");
    }

    @Test
    void testGetValue() {
        assertEquals(1, Rank.R1.getValue(), "Expected value for R1 is 1");
        assertEquals(2, Rank.R2.getValue(), "Expected value for R2 is 2");
        assertEquals(3, Rank.R3.getValue(), "Expected value for R3 is 3");
        assertEquals(4, Rank.R4.getValue(), "Expected value for R4 is 4");
        assertEquals(5, Rank.R5.getValue(), "Expected value for R5 is 5");
        assertEquals(6, Rank.R6.getValue(), "Expected value for R6 is 6");
        assertEquals(7, Rank.R7.getValue(), "Expected value for R7 is 7");
        assertEquals(8, Rank.R8.getValue(), "Expected value for R8 is 8");
    }

    @Test
    void testToString() {
        assertEquals("1", Rank.R1.toString(), "Expected string representation of R1 is '1'");
        assertEquals("2", Rank.R2.toString(), "Expected string representation of R2 is '2'");
        assertEquals("3", Rank.R3.toString(), "Expected string representation of R3 is '3'");
        assertEquals("4", Rank.R4.toString(), "Expected string representation of R4 is '4'");
        assertEquals("5", Rank.R5.toString(), "Expected string representation of R5 is '5'");
        assertEquals("6", Rank.R6.toString(), "Expected string representation of R6 is '6'");
        assertEquals("7", Rank.R7.toString(), "Expected string representation of R7 is '7'");
        assertEquals("8", Rank.R8.toString(), "Expected string representation of R8 is '8'");
    }

    @Test
    void testToRankValidCases() {
        assertEquals(Rank.R1, Rank.toRank(1), "Expected Rank.R1 for input 1");
        assertEquals(Rank.R2, Rank.toRank(2), "Expected Rank.R2 for input 2");
        assertEquals(Rank.R3, Rank.toRank(3), "Expected Rank.R3 for input 3");
        assertEquals(Rank.R4, Rank.toRank(4), "Expected Rank.R4 for input 4");
        assertEquals(Rank.R5, Rank.toRank(5), "Expected Rank.R5 for input 5");
        assertEquals(Rank.R6, Rank.toRank(6), "Expected Rank.R6 for input 6");
        assertEquals(Rank.R7, Rank.toRank(7), "Expected Rank.R7 for input 7");
        assertEquals(Rank.R8, Rank.toRank(8), "Expected Rank.R8 for input 8");
    }

    @Test
    void testToRankInvalidCases() {
        assertThrows(InvalidRankException.class, () -> Rank.toRank(0), "Expected InvalidRankException for input 0");
        assertThrows(InvalidRankException.class, () -> Rank.toRank(9), "Expected InvalidRankException for input 9");
        assertThrows(InvalidRankException.class, () -> Rank.toRank(-1), "Expected InvalidRankException for input -1");
    }

    @Test
    void testMoveForwardValidCases() {
        assertEquals(Rank.R2, Rank.move(Rank.R1, 1), "Expected Rank.R2 when moving forward 1 step from Rank.R1");
        assertEquals(Rank.R5, Rank.move(Rank.R3, 2), "Expected Rank.R5 when moving forward 2 steps from Rank.R3");
        assertEquals(Rank.R8, Rank.move(Rank.R7, 1), "Expected Rank.R8 when moving forward 1 step from Rank.R7");
    }

    @Test
    void testMoveForwardInvalidCases() {
        assertThrows(InvalidRankException.class, () -> Rank.move(Rank.R8, 1), "Expected InvalidRankException for invalid moving forward");
        assertThrows(InvalidRankException.class, () -> Rank.move(Rank.R6, 4), "Expected InvalidRankException for invalid moving forward");
    }

    @Test
    void testMoveBackwardValidCases() {
        assertEquals(Rank.R6, Rank.move(Rank.R7, -1), "Expected Rank.R6 when moving backward 1 step from Rank.R7");
        assertEquals(Rank.R3, Rank.move(Rank.R5, -2), "Expected Rank.R3 when moving backward 2 steps from Rank.R5");
        assertEquals(Rank.R1, Rank.move(Rank.R2, -1), "Expected Rank.R1 when moving backward 1 step from Rank.R2");
    }

    @Test
    void testMoveBackwardInvalidCases() {
        assertThrows(InvalidRankException.class, () -> Rank.move(Rank.R1, -1), "Expected InvalidFileException for invalid moving backward");
        assertThrows(InvalidRankException.class, () -> Rank.move(Rank.R3, -4), "Expected InvalidFileException for invalid moving backward");
    }
}
