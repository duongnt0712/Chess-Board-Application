package com.demo.chessboard.util;

import com.demo.chessboard.entity.base.Piece;
import com.demo.chessboard.entity.base.Position;
import com.demo.chessboard.enums.File;
import com.demo.chessboard.enums.PieceType;
import com.demo.chessboard.enums.Rank;
import com.demo.chessboard.enums.Side;
import com.demo.chessboard.factory.PieceFactory;
import com.demo.chessboard.entity.ChessBoard;
import com.demo.chessboard.exceptions.InvalidInputFormatException;
import com.demo.chessboard.exceptions.InvalidPieceCodeException;
import com.demo.chessboard.utils.PieceHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PieceHelperTest {

    private ChessBoard board;

    @BeforeEach
    void setUp() {
        board = new ChessBoard();
    }

    @Test
    void testParseInput_ValidInput() {
        // Given: A valid input string for the chessboard configuration
        String[] input = new String[] {"W: PE2, RA1, NB1, BC1, QD1, KE1", "B: PE7, PF7, PA7, RA7, NB8, BC8, QD8, KE8"};

        // When: Parsing the input
        ChessBoard resultBoard = PieceHelper.parseInput(input);

        // Then: The board should contain the correct pieces at the correct positions
        assertEquals(13, resultBoard.getAllPieces().size());

        Piece whitePawnE2 = resultBoard.getPiece(Position.builder().file(File.E).rank(Rank.R2).build());
        assertNotNull(whitePawnE2);
        assertEquals(Side.WHITE, whitePawnE2.getSide());

        Piece blackPawnE7 = resultBoard.getPiece(Position.builder().file(File.E).rank(Rank.R7).build());
        assertNotNull(blackPawnE7);
        assertEquals(Side.BLACK, blackPawnE7.getSide());
    }

    @Test
    void testParseInput_InvalidInputFormat() {
        // Given: An invalid input string with incorrect format: position X9
        String[] input = new String[] {"W: PE2, PF2", "B: PE7, PX9"};

        // Then: Parsing the input should throw an InvalidInputFormatException
        assertThrows(InvalidInputFormatException.class, () -> PieceHelper.parseInput(input));
    }

    @Test
    void testCreatePieceFromEntry_ValidPieceCode() {
        // Given: A valid piece entry
        String entry = "PE2";

        // When: Creating the piece from the entry
        Piece piece = PieceHelper.createPieceFromEntry(entry, new PieceFactory(Side.WHITE));

        // Then: The created piece should be a Pawn at position E2
        assertNotNull(piece);
        assertEquals(PieceType.PAWN, piece.getType());
        assertEquals(Position.builder().file(File.E).rank(Rank.R2).build(), piece.getPosition());
    }

    @Test
    void testCreatePieceFromEntry_InvalidPieceCode() {
        // Given: An invalid piece code
        String entry = "XE2";

        // Then: Creating the piece should throw an InvalidPieceCodeException
        assertThrows(InvalidPieceCodeException.class, () -> PieceHelper.createPieceFromEntry(entry, new PieceFactory(Side.WHITE)));
    }
}
