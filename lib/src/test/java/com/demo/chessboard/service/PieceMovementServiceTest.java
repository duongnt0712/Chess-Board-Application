package com.demo.chessboard.service;

import com.demo.chessboard.entity.Queen;
import com.demo.chessboard.entity.base.Piece;
import com.demo.chessboard.entity.base.Position;
import com.demo.chessboard.enums.PieceType;
import com.demo.chessboard.enums.Side;
import com.demo.chessboard.utils.PositionHelper;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PieceMovementServiceTest {

    Logger logger = Logger.getLogger(getClass().getName());

    @Test
    void testInitializeAndCalculateMoves_OnePiece() {
        // Given: Input representing a chessboard with one BISHOP at position D4
        String[] input = {"W: BD4"};

        // When: Create the service and run the method under test
        PieceMovementService service = PieceMovementService.createPieceMovementService();
        Map<Piece, Set<Position>> result = service.initializeAndCalculateMoves(input);

        // Then: Validate the size
        assertEquals(1, result.size(), "There should be one piece in the result");

        Piece bishop = result.keySet().iterator().next();
        Set<Position> moves = result.get(bishop);

        // Validate the piece properties
        assertEquals(PieceType.BISHOP, bishop.getType(), "The piece should be a bishop");
        assertEquals(Side.WHITE, bishop.getSide(), "The piece should belong to the WHITE side");
        assertEquals(PositionHelper.parsePosition("D4"), bishop.getPosition(), "The piece should be at position D4");

        // Validate the calculated moves
        Set<Position> expectedMoves = Set.of(
                PositionHelper.parsePosition("E5"), PositionHelper.parsePosition("F6"), PositionHelper.parsePosition("G7"),
                PositionHelper.parsePosition("C3"), PositionHelper.parsePosition("B2"), PositionHelper.parsePosition("A1"),
                PositionHelper.parsePosition("C5"), PositionHelper.parsePosition("B6"), PositionHelper.parsePosition("A7"),
                PositionHelper.parsePosition("E3"), PositionHelper.parsePosition("F2"), PositionHelper.parsePosition("G1"),
                PositionHelper.parsePosition("H8")
        );
        assertEquals(expectedMoves.size(), moves.size(), "The number of moves should match the expected");
        assertTrue(moves.containsAll(expectedMoves), "All expected moves should be present in the result");
    }

    @Test
    void testInitializeAndCalculateMoves_MultiPieces() {
        // Given: Input representing a chessboard with multi pieces
        String[] input = {"W: KE2, QD1, RA1, NB1, NF7, BC1, BC4, PA2, PB2, PC2, PD2, PG3", "B: KE8, QH1, RA8, RH8, ND1, BC8, PA7, PB7, PC7, PD7, PE5, PG7, PH7"};

        // When: Create the service and run the method under test
        PieceMovementService service = PieceMovementService.createPieceMovementService();
        Map<Piece, Set<Position>> result = service.initializeAndCalculateMoves(input);

        // Then: Assertions
        logger.info("\n==========RESULT==========");
        result.forEach((piece, moves) -> logger.info(String.format("%s %s at %s can move: %s%n", piece.getSide(), piece.getType(), piece.getPosition(), moves)));

        // Validate the size
        assertEquals(24, result.size());
//        Piece queen = Queen.builder().side(Side.WHITE).position(PositionHelper.parsePosition("D1")).build();
//        Set<Position> moves = result.get(queen);
//
//        // Validate the piece properties
//        assertEquals(PieceType.QUEEN, queen.getType(), "The piece should be a queen");
//        assertEquals(Side.WHITE, queen.getSide(), "The piece should belong to the WHITE side");
//        assertEquals(PositionHelper.parsePosition("D1"), queen.getPosition(), "The piece should be at position D1");
//
//        // Validate the calculated moves
//        Set<Position> expectedMoves = Set.of(
//                PositionHelper.parsePosition("E5"), PositionHelper.parsePosition("F6"), PositionHelper.parsePosition("G7"),
//                PositionHelper.parsePosition("C3"), PositionHelper.parsePosition("B2"), PositionHelper.parsePosition("A1"),
//                PositionHelper.parsePosition("C5"), PositionHelper.parsePosition("B6"), PositionHelper.parsePosition("A7"),
//                PositionHelper.parsePosition("E3"), PositionHelper.parsePosition("F2"), PositionHelper.parsePosition("G1"),
//                PositionHelper.parsePosition("H8")
//        );
//        assertEquals(expectedMoves.size(), moves.size(), "The number of moves should match the expected");
    }
}
