package com.demo.chessboard.service.move;

import com.demo.chessboard.entity.Rook;
import com.demo.chessboard.entity.base.Piece;
import com.demo.chessboard.entity.base.Position;
import com.demo.chessboard.enums.File;
import com.demo.chessboard.enums.Rank;
import com.demo.chessboard.enums.Side;
import com.demo.chessboard.entity.ChessBoard;
import com.demo.chessboard.move.RookMovement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RookMovementTest {

    private ChessBoard board;
    private Rook rook;

    @BeforeEach
    public void setUp() {
        board = new ChessBoard();
        Position position = Position.builder().file(File.D).rank(Rank.R4).build();
        rook = new Rook(Side.WHITE, position);
    }

    @Test
    void testCalculateAvailableMoves_OpenPath() {
        // Given: Rook at D4
        board.addPiece(rook);

        // When: Calculate available moves for rook
        Set<Position> availableMoves = new RookMovement().calculateAvailableMoves(board, rook);

        // Then: The rook should have all horizontal and vertical moves available
        assertTrue(availableMoves.contains(new Position(File.D, Rank.R5)));
        assertTrue(availableMoves.contains(new Position(File.E, Rank.R4)));
    }

    @Test
    void testCalculateAvailableMoves_BlockingFriendlyPiece() {
        // Given: Rook at D4 and a friendly piece at D5
        board.addPiece(rook);

        Position friendlyPiecePosition = Position.builder().file(File.D).rank(Rank.R5).build();
        Piece friendlyPiece = new Rook(Side.WHITE, friendlyPiecePosition);
        board.addPiece(friendlyPiece);

        // When: Calculate available moves for rook
        Set<Position> availableMoves = new RookMovement().calculateAvailableMoves(board, rook);

        // Then: The rook should not be able to move to D5 or beyond
        assertFalse(availableMoves.contains(new Position(File.D, Rank.R5)));
    }

    @Test
    void testCalculateAvailableMoves_CapturingOpponentPiece() {
        // Given: Rook at D4 and an opponent's piece at D5
        board.addPiece(rook);

        Position opponentPiecePosition = Position.builder().file(File.D).rank(Rank.R5).build();
        Piece opponentPiece = new Rook(Side.BLACK, opponentPiecePosition);
        board.addPiece(opponentPiece);

        // When: Calculate available moves for rook
        Set<Position> availableMoves = new RookMovement().calculateAvailableMoves(board, rook);

        // Then: The rook should be able to capture the opponent's piece at D5
        assertTrue(availableMoves.contains(new Position(File.D, Rank.R5)));
    }
}
