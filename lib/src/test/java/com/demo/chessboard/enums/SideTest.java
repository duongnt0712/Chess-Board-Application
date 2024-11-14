package com.demo.chessboard.enums;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SideTest {
    @Test
    void testEnumValues() {
        assertEquals(2, Side.values().length, "Side enum should contain exactly 2 values");
        assertSame(Side.BLACK, Side.valueOf("BLACK"), "Expected Side.BLACK for 'BLACK'");
        assertSame(Side.WHITE, Side.valueOf("WHITE"), "Expected Side.WHITE for 'WHITE'");
    }
}
