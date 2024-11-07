package com.demo.chessboard.factory;

import com.demo.chessboard.entity.*;
import com.demo.chessboard.entity.base.Piece;
import com.demo.chessboard.entity.base.Position;
import com.demo.chessboard.enums.File;
import com.demo.chessboard.enums.PieceType;
import com.demo.chessboard.enums.Rank;
import com.demo.chessboard.enums.Side;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PieceFactoryTest {

    @Test
    void shouldCreateBishopWithTypeAndSide() {
        Position position = Position.builder().file(File.E).rank(Rank.R3).build();
        Piece bishop = new PieceFactory(Side.BLACK).createPiece(PieceType.BISHOP, position);
        assertTrue(bishop instanceof Bishop);
        assertEquals(PieceType.BISHOP, bishop.getType());
        assertEquals(Side.BLACK, bishop.getSide());
        assertEquals("E3", bishop.getPosition().toString());
    }

    @Test
    void shouldCreateKingWithTypeAndSide() {
        Position position = Position.builder().file(File.D).rank(Rank.R8).build();
        Piece king = new PieceFactory(Side.BLACK).createPiece(PieceType.KING, position);
        assertTrue(king instanceof King);
        assertEquals(PieceType.KING, king.getType());
        assertEquals(Side.BLACK, king.getSide());
        assertEquals("D8", king.getPosition().toString());
    }

    @Test
    void shouldCreateKnightWithTypeAndSide() {
        Position position = Position.builder().file(File.F).rank(Rank.R6).build();
        Piece knight = new PieceFactory(Side.BLACK).createPiece(PieceType.KNIGHT, position);
        assertTrue(knight instanceof Knight);
        assertEquals(PieceType.KNIGHT, knight.getType());
        assertEquals(Side.BLACK, knight.getSide());
        assertEquals("F6", knight.getPosition().toString());
    }

    @Test
    void shouldCreatePawnWithTypeAndSide() {
        Position position = Position.builder().file(File.H).rank(Rank.R2).build();
        Piece pawn = new PieceFactory(Side.WHITE).createPiece(PieceType.PAWN, position);
        assertTrue(pawn instanceof Pawn);
        assertEquals(PieceType.PAWN, pawn.getType());
        assertEquals(Side.WHITE, pawn.getSide());
        assertEquals("H2", pawn.getPosition().toString());
    }

    @Test
    void shouldCreateQueenWithTypeAndSide() {
        Position position = Position.builder().file(File.H).rank(Rank.R2).build();
        Piece queen = new PieceFactory(Side.WHITE).createPiece(PieceType.QUEEN, position);

        assertTrue(queen instanceof Queen);
        assertEquals(PieceType.QUEEN, queen.getType());
        assertEquals(Side.WHITE, queen.getSide());
        assertEquals("H2", queen.getPosition().toString());
    }

    @Test
    void shouldCreateRookWithTypeAndSide() {
        Position position = Position.builder().file(File.A).rank(Rank.R2).build();
        Piece rook = new PieceFactory(Side.WHITE).createPiece(PieceType.ROOK, position);
        assertTrue(rook instanceof Rook);
        assertEquals(PieceType.ROOK, rook.getType());
        assertEquals(Side.WHITE, rook.getSide());
        assertEquals("A2", rook.getPosition().toString());
    }

}
