package com.demo.chessboard.service.move;

import com.demo.chessboard.entity.Knight;
import com.demo.chessboard.entity.base.Piece;
import com.demo.chessboard.entity.base.Position;
import com.demo.chessboard.enums.File;
import com.demo.chessboard.enums.Rank;
import com.demo.chessboard.enums.Side;
import com.demo.chessboard.entity.ChessBoard;
import com.demo.chessboard.move.KnightMovement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class KnightMovementTest {

    private ChessBoard board;
    private Knight knight;

    @BeforeEach
    public void setUp() {
        board = new ChessBoard();
        Position position = Position.builder().file(File.D).rank(Rank.R4).build();
        knight = new Knight(Side.WHITE, position);
    }

    @Test
    void testCalculateAvailableMoves_OpenPath() {
        // Given: Knight at D4
        board.addPiece(knight);

        // When: Calculate available moves for knight
        Set<Position> availableMoves = new KnightMovement().calculateAvailableMoves(board, knight);

        // Then: The knight should have all L-shaped moves available
        assertTrue(availableMoves.contains(new Position(File.C, Rank.R6)));
        assertTrue(availableMoves.contains(new Position(File.E, Rank.R6)));
        assertTrue(availableMoves.contains(new Position(File.F, Rank.R5)));
        assertTrue(availableMoves.contains(new Position(File.F, Rank.R3)));
        assertTrue(availableMoves.contains(new Position(File.E, Rank.R2)));
        assertTrue(availableMoves.contains(new Position(File.C, Rank.R2)));
        assertTrue(availableMoves.contains(new Position(File.B, Rank.R3)));
        assertTrue(availableMoves.contains(new Position(File.B, Rank.R5)));
    }

    @Test
    void testCalculateAvailableMoves_BlockingFriendlyPiece() {
        // Given: Knight at D4 and a friendly piece at F5
        board.addPiece(knight);

        Position friendlyPiecePosition = Position.builder().file(File.F).rank(Rank.R5).build();
        Piece friendlyPiece = new Knight(Side.WHITE, friendlyPiecePosition);
        board.addPiece(friendlyPiece);

        // When: Calculate available moves for knight
        Set<Position> availableMoves = new KnightMovement().calculateAvailableMoves(board, knight);

        // Then: The knight should not be able to move to F5
        assertFalse(availableMoves.contains(new Position(File.F, Rank.R5)));
    }

    @Test
    void testCalculateAvailableMoves_CapturingOpponentPiece() {
        // Given: Knight at D4 and an opponent's piece at F5
        board.addPiece(knight);

        Position opponentPiecePosition = Position.builder().file(File.F).rank(Rank.R5).build();
        Piece opponentPiece = new Knight(Side.BLACK, opponentPiecePosition);
        board.addPiece(opponentPiece);

        // When: Calculate available moves for knight
        Set<Position> availableMoves = new KnightMovement().calculateAvailableMoves(board, knight);

        // Then: The knight should be able to capture the opponent's piece at F5
        assertTrue(availableMoves.contains(new Position(File.F, Rank.R5)));
    }
}
