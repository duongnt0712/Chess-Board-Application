package com.demo.chessboard.factory;

import com.demo.chessboard.entity.*;
import com.demo.chessboard.entity.base.Piece;
import com.demo.chessboard.enums.PieceType;
import com.demo.chessboard.enums.Side;
import com.demo.chessboard.service.PieceMovementService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PieceFactoryTest {

    @Test
    void shouldCreateBishopWithTypeAndSide() {
        Piece bishop = new PieceFactory(Side.BLACK).createPiece(PieceType.BISHOP, PieceMovementService.parsePosition("E3"));
        assertTrue(bishop instanceof Bishop);
        assertEquals(PieceType.BISHOP, bishop.getType());
        assertEquals(Side.BLACK, bishop.getSide());
        assertEquals("E3", bishop.getPosition().toString());
    }

    @Test
    void shouldCreateKingWithTypeAndSide() {
        Piece king = new PieceFactory(Side.BLACK).createPiece(PieceType.KING, PieceMovementService.parsePosition("D8"));
        assertTrue(king instanceof King);
        assertEquals(PieceType.KING, king.getType());
        assertEquals(Side.BLACK, king.getSide());
        assertEquals("D8", king.getPosition().toString());
    }

    @Test
    void shouldCreateKnightWithTypeAndSide() {
        Piece knight = new PieceFactory(Side.BLACK).createPiece(PieceType.KNIGHT, PieceMovementService.parsePosition("F6"));
        assertTrue(knight instanceof Knight);
        assertEquals(PieceType.KNIGHT, knight.getType());
        assertEquals(Side.BLACK, knight.getSide());
        assertEquals("F6", knight.getPosition().toString());
    }

    @Test
    void shouldCreatePawnWithTypeAndSide() {
        Piece pawn = new PieceFactory(Side.WHITE).createPiece(PieceType.PAWN, PieceMovementService.parsePosition("H2"));
        assertTrue(pawn instanceof Pawn);
        assertEquals(PieceType.PAWN, pawn.getType());
        assertEquals(Side.WHITE, pawn.getSide());
        assertEquals("H2", pawn.getPosition().toString());
    }

    @Test
    void shouldCreateQueenWithTypeAndSide() {
        Piece queen = new PieceFactory(Side.WHITE).createPiece(PieceType.QUEEN, PieceMovementService.parsePosition("H2"));
        assertTrue(queen instanceof Queen);
        assertEquals(PieceType.QUEEN, queen.getType());
        assertEquals(Side.WHITE, queen.getSide());
        assertEquals("H2", queen.getPosition().toString());
    }

    @Test
    void shouldCreateRookWithTypeAndSide() {
        Piece rook = new PieceFactory(Side.WHITE).createPiece(PieceType.ROOK, PieceMovementService.parsePosition("A2"));
        assertTrue(rook instanceof Rook);
        assertEquals(PieceType.ROOK, rook.getType());
        assertEquals(Side.WHITE, rook.getSide());
        assertEquals("A2", rook.getPosition().toString());
    }

}
