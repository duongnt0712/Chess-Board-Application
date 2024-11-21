package com.demo.chessboard.util;

import com.demo.chessboard.entity.base.Position;
import com.demo.chessboard.enums.File;
import com.demo.chessboard.enums.Rank;
import com.demo.chessboard.enums.Side;
import com.demo.chessboard.exceptions.InvalidRankException;
import com.demo.chessboard.utils.PositionHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PositionHelperTest {

    private Position whitePawnPosition;
    private Position blackPawnPosition;

    @BeforeEach
    void setUp() {
        whitePawnPosition = new Position(File.E, Rank.R2);  // White pawn at E2
        blackPawnPosition = new Position(File.E, Rank.R7);  // Black pawn at E7
    }

    @Test
    void testParsePosition_ValidInput() {
        // Given: A valid position code string
        String positionCode = "E2";

        // When: Parsing the position string
        Position position = PositionHelper.parsePosition(positionCode);

        // Then: The position should be E2
        assertEquals(File.E, position.file());
        assertEquals(Rank.R2, position.rank());
    }

    @Test
    void testParsePosition_InvalidInput() {
        // Given: An invalid position code string
        String positionCode = "I9";  // Invalid position (I9 doesn't exist)

        // When & Then: Parsing the position string should throw an IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> PositionHelper.parsePosition(positionCode));
    }

    @Test
    void testIsValidMove_ValidMove() {
        // Given: A position and valid horizontal and vertical steps
        Position position = whitePawnPosition;
        int horizontalSteps = 0;
        int verticalSteps = 1;

        // When: Checking if the move is valid
        boolean isValid = PositionHelper.isValidMove(position, horizontalSteps, verticalSteps);

        // Then: The move should be valid
        assertTrue(isValid);
    }

    @Test
    void testIsValidMove_InvalidMove() {
        // Given: A position and invalid horizontal and vertical steps
        Position position = whitePawnPosition;
        int horizontalSteps = 0;
        int verticalSteps = 9;  // Invalid for a pawn

        // When: Checking if the move is valid
        boolean isValid = PositionHelper.isValidMove(position, horizontalSteps, verticalSteps);

        // Then: The move should be invalid
        assertFalse(isValid);
    }

    @Test
    void testMove_ValidMove() {
        // Given: A position and valid horizontal and vertical steps
        Position position = whitePawnPosition;
        int horizontalSteps = 0;
        int verticalSteps = 1;

        // When: Moving the position
        Position newPosition = PositionHelper.move(position, horizontalSteps, verticalSteps);

        // Then: The new position should be E3
        assertEquals(File.E, newPosition.file());
        assertEquals(Rank.R3, newPosition.rank());
    }

    @Test
    void testMove_OutOfBounds() {
        // Given: A position on the edge of the board (e.g., E8)
        Position position = new Position(File.E, Rank.R8);
        int horizontalSteps = 0;
        int verticalSteps = 1;  // Moving off the board

        // Then: The new position should be true
        assertThrows(InvalidRankException.class, () -> PositionHelper.move(position, horizontalSteps, verticalSteps));
    }

    @Test
    void testIsInitialPosition_WhiteSide() {
        // Given: A white pawn at E2 (should be the initial position)
        Position position = whitePawnPosition;
        Side side = Side.WHITE;

        // When: Checking if the position is the initial position for white
        boolean isInitial = PositionHelper.isInitialPosition(side, position);

        // Then: The result should be true
        assertTrue(isInitial);
    }

    @Test
    void testIsInitialPosition_BlackSide() {
        // Given: A black pawn at E7 (should be the initial position)
        Position position = blackPawnPosition;
        Side side = Side.BLACK;

        // When: Checking if the position is the initial position for black
        boolean isInitial = PositionHelper.isInitialPosition(side, position);

        // Then: The result should be true
        assertTrue(isInitial);
    }

    @Test
    void testIsInitialPosition_InvalidRank() {
        // Given: A position that is not the initial position (e.g., white pawn at E3)
        Position position = new Position(File.E, Rank.R3);
        Side side = Side.WHITE;

        // When: Checking if the position is the initial position for white
        boolean isInitial = PositionHelper.isInitialPosition(side, position);

        // Then: The result should be false
        assertFalse(isInitial);
    }
}
