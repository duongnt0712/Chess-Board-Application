package com.demo.chessboard.utils;

import com.demo.chessboard.entity.base.Piece;
import com.demo.chessboard.entity.base.Position;
import com.demo.chessboard.enums.PieceType;
import com.demo.chessboard.enums.Side;
import com.demo.chessboard.exceptions.InvalidInputFormatException;
import com.demo.chessboard.exceptions.InvalidPieceCodeException;
import com.demo.chessboard.exceptions.InvalidSideException;
import com.demo.chessboard.factory.AbstractPieceFactory;
import com.demo.chessboard.factory.PieceFactory;
import com.demo.chessboard.entity.ChessBoard;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PieceHelper {

    private PieceHelper() {
        throw new IllegalStateException("Utility class");
    }

    public static ChessBoard parseInput(String[] lines) {
        ChessBoard board = new ChessBoard();

        for (String line : lines) {
            String[] input = line.split(":");
            Side side = getSide(input[0].trim());
            AbstractPieceFactory factory = new PieceFactory(side);
            String[] pieceEntries = input[1].split(",");
            createPieceFromEntries(pieceEntries, factory, board);
        }
        return board;
    }

    private static void createPieceFromEntries(String[] pieceEntries, AbstractPieceFactory factory, ChessBoard board) {
        for (String entry : pieceEntries) {
            entry = entry.trim();
            if (!entry.isEmpty()) {
                Piece piece = createPieceFromEntry(entry, factory);
                board.addPiece(piece);
            }
        }
    }

    public static Piece createPieceFromEntry(String entry, AbstractPieceFactory factory) {
        Pattern pattern = Pattern.compile("([A-Za-z])([A-Ha-h][1-8])");
        Matcher matcher = pattern.matcher(entry);

        if (matcher.matches()) {
            String pieceCode = matcher.group(1);
            String positionCode = matcher.group(2);

            PieceType pieceType = getPieceType(pieceCode);

            Position position = PositionHelper.parsePosition(positionCode);
            return factory.createPiece(pieceType, position);
        }
        throw new InvalidInputFormatException(entry);
    }

    private static PieceType getPieceType(String pieceCode) {
        return switch (pieceCode.toUpperCase()) {
            case "K" -> PieceType.KING;
            case "Q" -> PieceType.QUEEN;
            case "R" -> PieceType.ROOK;
            case "N" -> PieceType.KNIGHT;
            case "B" -> PieceType.BISHOP;
            case "P" -> PieceType.PAWN;
            default -> throw new InvalidPieceCodeException(pieceCode);
        };
    }

    private static Side getSide(String side) {
        return switch (side.toUpperCase()) {
            case "W" -> Side.WHITE;
            case "B" -> Side.BLACK;
            default -> throw new InvalidSideException(side);
        };
    }
}
