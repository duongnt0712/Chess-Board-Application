package com.demo.chessboard.service.move;

import com.demo.chessboard.entity.King;
import com.demo.chessboard.entity.base.Piece;
import com.demo.chessboard.entity.base.Position;
import com.demo.chessboard.enums.File;
import com.demo.chessboard.enums.Rank;
import com.demo.chessboard.enums.Side;
import com.demo.chessboard.entity.ChessBoard;
import com.demo.chessboard.move.KingMovement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class KingMovementTest {
    private ChessBoard board;
    private King king;

    @BeforeEach
    public void setUp() {
        board = new ChessBoard();
        Position position = Position.builder().file(File.E).rank(Rank.R4).build();
        king = new King(Side.WHITE, position);
    }

    @Test
    void testCalculateAvailableMoves_OpenPath() {
        // Given: King at E4
        board.addPiece(king);

        // When: Calculate available moves for king
        Set<Position> availableMoves = new KingMovement().calculateAvailableMoves(board, king);

        // Then: The king should have all 8 adjacent squares available
        assertTrue(availableMoves.contains(new Position(File.D, Rank.R3)));
        assertTrue(availableMoves.contains(new Position(File.E, Rank.R3)));
        assertTrue(availableMoves.contains(new Position(File.F, Rank.R3)));
        assertTrue(availableMoves.contains(new Position(File.D, Rank.R4)));
        assertTrue(availableMoves.contains(new Position(File.F, Rank.R4)));
        assertTrue(availableMoves.contains(new Position(File.D, Rank.R5)));
        assertTrue(availableMoves.contains(new Position(File.E, Rank.R5)));
        assertTrue(availableMoves.contains(new Position(File.F, Rank.R5)));
    }

    @Test
    void testCalculateAvailableMoves_BlockingFriendlyPiece() {
        // Given: King at E4 and a friendly piece at F5
        board.addPiece(king);

        Position friendlyPiecePosition = Position.builder().file(File.F).rank(Rank.R5).build();
        Piece friendlyPiece = new King(Side.WHITE, friendlyPiecePosition);
        board.addPiece(friendlyPiece);

        // When: Calculate available moves for king
        Set<Position> availableMoves = new KingMovement().calculateAvailableMoves(board, king);

        // Then: The king should not be able to move to F5
        assertFalse(availableMoves.contains(new Position(File.F, Rank.R5)));
    }

    @Test
    void testCalculateAvailableMoves_CapturingOpponentPiece() {
        // Given: King at E4 and an opponent's piece at D3
        board.addPiece(king);

        Position opponentPiecePosition = Position.builder().file(File.D).rank(Rank.R3).build();
        Piece opponentPiece = new King(Side.BLACK, opponentPiecePosition);
        board.addPiece(opponentPiece);

        // When: Calculate available moves for king
        Set<Position> availableMoves = new KingMovement().calculateAvailableMoves(board, king);

        // Then: The king should be able to capture the opponent's piece at D3
        assertTrue(availableMoves.contains(new Position(File.D, Rank.R3)));
    }
}
