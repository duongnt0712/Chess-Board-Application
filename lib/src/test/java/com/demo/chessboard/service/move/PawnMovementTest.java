package com.demo.chessboard.service.move;

import com.demo.chessboard.entity.Pawn;
import com.demo.chessboard.entity.base.Piece;
import com.demo.chessboard.entity.base.Position;
import com.demo.chessboard.enums.File;
import com.demo.chessboard.enums.Rank;
import com.demo.chessboard.enums.Side;
import com.demo.chessboard.entity.ChessBoard;
import com.demo.chessboard.move.PawnMovement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PawnMovementTest {

    private ChessBoard board;
    private Pawn whitePawn;
    private Pawn blackPawn;

    @BeforeEach
    void setUp() {
        board = new ChessBoard();
        Position whitePawnPosition = Position.builder().file(File.E).rank(Rank.R2).build();
        Position blackPawnPosition = Position.builder().file(File.E).rank(Rank.R7).build();
        whitePawn = new Pawn(Side.WHITE, whitePawnPosition);
        blackPawn = new Pawn(Side.BLACK, blackPawnPosition);
    }

    @Test
    void testCalculateAvailableMoves_WhitePawn_MoveForward() {
        // Given: White pawn at E4
        Position whitePawnPosition = Position.builder().file(File.E).rank(Rank.R4).build();
        Piece movedWhitePawn = new Pawn(Side.WHITE, whitePawnPosition);
        board.addPiece(movedWhitePawn);

        // When: Calculate available moves for white pawn
        Set<Position> availableMoves = new PawnMovement().calculateAvailableMoves(board, movedWhitePawn);

        // Then: White pawn should have the option to move to E5
        assertTrue(availableMoves.contains(new Position(File.E, Rank.R5)));
    }

    @Test
    void testCalculateAvailableMoves_WhitePawn_DoubleMoveFromStart() {
        // Given: White pawn at E2
        board.addPiece(whitePawn);

        // When: Calculate available moves for white pawn
        Set<Position> availableMoves = new PawnMovement().calculateAvailableMoves(board, whitePawn);

        // Then: White pawn should have the option to move two squares ahead to E4
        assertTrue(availableMoves.contains(new Position(File.E, Rank.R4)));
    }

    @Test
    void testCalculateAvailableMoves_BlackPawn_MoveForward() {
        // Given: Black pawn at E7
        board.addPiece(blackPawn);

        // When: Calculate available moves for black pawn
        Set<Position> availableMoves = new PawnMovement().calculateAvailableMoves(board, blackPawn);

        // Then: Black pawn should have the option to move to E6
        assertTrue(availableMoves.contains(new Position(File.E, Rank.R6)));
    }

    @Test
    void testCalculateAvailableMoves_BlackPawn_DoubleMoveFromStart() {
        // Given: Black pawn at E7
        board.addPiece(blackPawn);

        // When: Calculate available moves for black pawn
        Set<Position> availableMoves = new PawnMovement().calculateAvailableMoves(board, blackPawn);

        // Then: Black pawn should have the option to move two squares ahead to E5
        assertTrue(availableMoves.contains(new Position(File.E, Rank.R5)));
    }

    @Test
    void testCalculateAvailableMoves_CaptureWhitePawn() {
        // Given: White pawn at E3 and a black pawn at D4
        Position whitePawnPosition = Position.builder().file(File.E).rank(Rank.R3).build();
        Position blackPawnPosition = Position.builder().file(File.D).rank(Rank.R4).build();
        whitePawn = new Pawn(Side.WHITE, whitePawnPosition);
        blackPawn = new Pawn(Side.BLACK, blackPawnPosition);
        board.addPiece(whitePawn);
        board.addPiece(blackPawn);

        // When: Calculate available moves for the white pawn at E3
        Set<Position> availableMoves = new PawnMovement().calculateAvailableMoves(board, whitePawn);
        availableMoves.stream().forEach(move -> System.out.println(move.toString()));

        // Then: White pawn should be able to capture the black pawn at D4
        assertTrue(availableMoves.contains(new Position(File.D, Rank.R4)));
    }

    @Test
    void testCalculateAvailableMoves_CaptureBlackPawn() {
        // Given: Black pawn at E6 and a white pawn at F5
        Position whitePawnPosition = Position.builder().file(File.F).rank(Rank.R5).build();
        Position blackPawnPosition = Position.builder().file(File.E).rank(Rank.R6).build();
        whitePawn = new Pawn(Side.WHITE, whitePawnPosition);
        blackPawn = new Pawn(Side.BLACK, blackPawnPosition);
        board.addPiece(whitePawn);
        board.addPiece(blackPawn);

        // When: Calculate available moves for the black pawn at E6
        Set<Position> availableMoves = new PawnMovement().calculateAvailableMoves(board, blackPawn);

        // Then: Black pawn should be able to capture the white pawn at F5
        assertTrue(availableMoves.contains(new Position(File.F, Rank.R5)));
    }

    @Test
    void testCalculateAvailableMoves_BlockingPiece() {
        // Given: White pawn at E2 and a piece blocking at E3
        board.addPiece(whitePawn);
        Position whitePawnPosition = Position.builder().file(File.E).rank(Rank.R3).build();
        board.addPiece(new Pawn(Side.WHITE, whitePawnPosition));

        // When: Calculate available moves for white pawn
        Set<Position> availableMoves = new PawnMovement().calculateAvailableMoves(board, whitePawn);

        // Then: White pawn should not be able to move to E3 due to blocking piece
        assertFalse(availableMoves.contains(new Position(File.E, Rank.R3)));
    }
}
