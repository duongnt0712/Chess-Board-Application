package com.demo.chessboard.entity;

import com.demo.chessboard.entity.base.Position;
import com.demo.chessboard.enums.File;
import com.demo.chessboard.enums.Rank;
import com.demo.chessboard.exceptions.InvalidFileException;
import com.demo.chessboard.exceptions.InvalidRankException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PositionTest {

    @Test
    void shouldEqualPositionToString() {
        Position position = Position.builder().file(File.D).rank(Rank.R1).build();
        assertEquals("D1", position.toString());
    }

    @Test
    void shouldReturnPositionInvalidException() {
        assertThrows(InvalidRankException.class, () -> Position.builder().file(File.toFile('D')).rank(Rank.toRank(9)).build());
        assertThrows(InvalidFileException.class, () -> Position.builder().file(File.toFile('X')).rank(Rank.toRank(3)).build());
    }
}
