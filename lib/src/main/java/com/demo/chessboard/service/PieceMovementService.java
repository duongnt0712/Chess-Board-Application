package com.demo.chessboard.service;
import com.demo.chessboard.entity.base.Position;
import com.demo.chessboard.entity.base.Piece;
import com.demo.chessboard.enums.PieceType;
import com.demo.chessboard.enums.Side;
import com.demo.chessboard.exceptions.InvalidInputFormatException;
import com.demo.chessboard.exceptions.InvalidPieceCodeException;
import com.demo.chessboard.factory.AbstractPieceFactory;
import com.demo.chessboard.factory.PieceFactory;
import com.demo.chessboard.utils.PositionHelper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Convert the input data to the right piece format
 */
public class PieceMovementService {

    private PieceMovementService() {
    }

    public static PieceMovementService createPieceMovementService() {
        return new PieceMovementService();
    }

    public static ChessBoard parseInput(String input) {
        ChessBoard board = new ChessBoard();
        String[] lines = input.split("\n");

        for (String line : lines) {
            if (line.trim().isEmpty()) continue;
            Side side = line.toUpperCase().startsWith("W") ? Side.WHITE : Side.BLACK;
            AbstractPieceFactory factory = new PieceFactory(side);
            String[] pieceEntries = line.replace("W: ", "").replace("B: ", "").split(",");
            for (String entry : pieceEntries) {
                entry = entry.trim();
                if (!entry.isEmpty()) {
                    Piece piece = createPieceFromEntry(entry, factory);
                    board.addPiece(piece);
                }
            }
        }
        return board;
    }

    public static Piece createPieceFromEntry(String entry, AbstractPieceFactory factory) {
        Pattern pattern = Pattern.compile("([A-Za-z])([A-Ha-h][1-8])");
        Matcher matcher = pattern.matcher(entry);

        if (matcher.matches()) {
            String pieceCode = matcher.group(1);
            String positionCode = matcher.group(2);

            PieceType pieceType = switch (pieceCode.toUpperCase()) {
                case "K" -> PieceType.KING;
                case "Q" -> PieceType.QUEEN;
                case "R" -> PieceType.ROOK;
                case "N" -> PieceType.KNIGHT;
                case "B" -> PieceType.BISHOP;
                case "P" -> PieceType.PAWN;
                default -> throw new InvalidPieceCodeException(pieceCode);
            };

            Position position = PositionHelper.parsePosition(positionCode);
            return factory.createPiece(pieceType, position);
        }
        throw new InvalidInputFormatException(entry);
    }
}
