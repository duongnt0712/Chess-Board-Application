package com.demo.chessboard.entity;

import com.demo.chessboard.entity.base.Position;
import com.demo.chessboard.enums.File;
import com.demo.chessboard.enums.Rank;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PositionTest {

    @Test
    void shouldEqualPositionToString() {
        Position position = new Position(File.D, Rank.R1);
        assertEquals("D1", position.toString());
    }
}
