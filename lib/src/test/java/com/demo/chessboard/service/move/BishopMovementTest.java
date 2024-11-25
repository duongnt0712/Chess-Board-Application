package com.demo.chessboard.service.move;

import com.demo.chessboard.entity.Bishop;
import com.demo.chessboard.entity.Pawn;
import com.demo.chessboard.entity.base.Piece;
import com.demo.chessboard.entity.base.Position;
import com.demo.chessboard.enums.File;
import com.demo.chessboard.enums.Rank;
import com.demo.chessboard.enums.Side;
import com.demo.chessboard.entity.ChessBoard;
import com.demo.chessboard.move.BishopMovement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BishopMovementTest {

    private ChessBoard board;
    private Bishop bishop;

    @BeforeEach
    public void setUp() {
        board = new ChessBoard();
        Position position = Position.builder().file(File.D).rank(Rank.R4).build();
        bishop = new Bishop( Side.WHITE, position);
    }

    @Test
    void testCalculateAvailableMoves_OpenPath() {
        // Given: Bishop at D4
        board.addPiece(bishop);

        // When: Calculate available moves for bishop
        Set<Position> availableMoves = new BishopMovement().calculateAvailableMoves(board, bishop);

        // Then: The bishop should have available moves along diagonals
        assertTrue(availableMoves.contains(new Position(File.E, Rank.R5)));
        assertTrue(availableMoves.contains(new Position(File.C, Rank.R3)));
        assertTrue(availableMoves.contains(new Position(File.B, Rank.R2)));
        assertTrue(availableMoves.contains(new Position(File.A, Rank.R1)));
    }

    @Test
    void testCalculateAvailableMoves_BlockingFriendlyPiece() {
        // Given: Bishop at D4 and a friendly piece at E5
        board.addPiece(bishop);

        Position friendlyPiecePosition = Position.builder().file(File.E).rank(Rank.R5).build();
        Piece friendlyPiece = new Pawn(Side.WHITE, friendlyPiecePosition);
        board.addPiece(friendlyPiece);

        // When: Calculate available moves for bishop
        Set<Position> availableMoves = new BishopMovement().calculateAvailableMoves(board, bishop);

        // Then: The bishop should not be able to move to E5 because it's blocked by a friendly piece
        assertFalse(availableMoves.contains(new Position(File.E, Rank.R5)));
    }

    @Test
    void testCalculateAvailableMoves_CapturingOpponentPiece() {
        // Given: Bishop at D4 and an opponent's piece at E5
        board.addPiece(bishop);

        Position oponentPiecePosition = Position.builder().file(File.E).rank(Rank.R5).build();
        Piece opponentPiece = new Pawn( Side.BLACK, oponentPiecePosition);
        board.addPiece(opponentPiece);

        // When: Calculate available moves for bishop
        Set<Position> availableMoves = new BishopMovement().calculateAvailableMoves(board, bishop);

        // Then: The bishop should be able to capture the opponent's piece at E5
        assertTrue(availableMoves.contains(new Position(File.E, Rank.R5)));
    }
}
