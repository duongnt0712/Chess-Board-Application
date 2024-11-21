package com.demo.chessboard.service.impl;

import com.demo.chessboard.entity.Queen;
import com.demo.chessboard.entity.base.Piece;
import com.demo.chessboard.entity.base.Position;
import com.demo.chessboard.enums.File;
import com.demo.chessboard.enums.Rank;
import com.demo.chessboard.enums.Side;
import com.demo.chessboard.service.ChessBoard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class QueenMovementTest {

    private ChessBoard board;
    private Queen queen;

    @BeforeEach
    public void setUp() {
        board = new ChessBoard();
        Position position = Position.builder().file(File.D).rank(Rank.R4).build();
        queen = new Queen(Side.WHITE, position);
    }

    @Test
    void testCalculateAvailableMoves_OpenPath() {
        // Given: Queen at D4
        board.addPiece(queen);

        // When: Calculate available moves for queen
        Set<Position> availableMoves = new QueenMovement().calculateAvailableMoves(board, queen);

        // Then: The queen should have all horizontal, vertical, and diagonal moves available
        assertTrue(availableMoves.contains(new Position(File.D, Rank.R5)));
        assertTrue(availableMoves.contains(new Position(File.E, Rank.R4)));
        assertTrue(availableMoves.contains(new Position(File.C, Rank.R5)));
    }

    @Test
    void testCalculateAvailableMoves_BlockingFriendlyPiece() {
        // Given: Queen at D4 and a friendly piece at D5
        board.addPiece(queen);

        Position friendlyPiecePosition = Position.builder().file(File.D).rank(Rank.R5).build();
        Piece friendlyPiece = new Queen(Side.WHITE, friendlyPiecePosition);
        board.addPiece(friendlyPiece);

        // When: Calculate available moves for queen
        Set<Position> availableMoves = new QueenMovement().calculateAvailableMoves(board, queen);

        // Then: The queen should not be able to move to D5 or beyond
        assertFalse(availableMoves.contains(new Position(File.D, Rank.R5)));
    }

    @Test
    void testCalculateAvailableMoves_CapturingOpponentPiece() {
        // Given: Queen at D4 and an opponent's piece at C5
        board.addPiece(queen);

        Position opponentPiecePosition = Position.builder().file(File.C).rank(Rank.R5).build();
        Piece opponentPiece = new Queen(Side.BLACK, opponentPiecePosition);
        board.addPiece(opponentPiece);

        // When: Calculate available moves for queen
        Set<Position> availableMoves = new QueenMovement().calculateAvailableMoves(board, queen);

        // Then: The queen should be able to capture the opponent's piece at C5
        assertTrue(availableMoves.contains(new Position(File.C, Rank.R5)));
    }
}
