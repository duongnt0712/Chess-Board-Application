package com.demo.chessboard.service;
import com.demo.chessboard.entity.base.Position;
import com.demo.chessboard.entity.base.Piece;
import com.demo.chessboard.enums.PieceType;
import com.demo.chessboard.exceptions.InvalidInputFormatException;
import com.demo.chessboard.exceptions.InvalidPieceCodeException;
import com.demo.chessboard.factory.AbstractPieceFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Convert the input data to the right piece format
 */
public class PieceMovementService {

    public static void parseInput(String input, ChessBoard board, AbstractPieceFactory whiteFactory, AbstractPieceFactory blackFactory) {
        String[] sides = input.split("W:|B:");

        for (String side : sides) {
            if (side.trim().isEmpty()) continue;

            AbstractPieceFactory factory = side.contains("W:") ? whiteFactory : blackFactory;
            String[] pieceEntries = side.split(",");

            for (String entry : pieceEntries) {
                entry = entry.trim();
                if (!entry.isEmpty()) {
                    Piece piece = createPieceFromEntry(entry, factory);
                    board.addPiece(piece);
                }
            }
        }
    }

    private static Piece createPieceFromEntry(String entry, AbstractPieceFactory factory) {
        Pattern pattern = Pattern.compile("([A-Z])([A-H][1-8])");
        Matcher matcher = pattern.matcher(entry);

        if (matcher.matches()) {
            String pieceCode = matcher.group(1);
            String positionCode = matcher.group(2);

            PieceType pieceType = switch (pieceCode) {
                case "K" -> PieceType.KING;
                case "Q" -> PieceType.QUEEN;
                case "R" -> PieceType.ROOK;
                case "N" -> PieceType.KNIGHT;
                case "B" -> PieceType.BISHOP;
                case "P" -> PieceType.PAWN;
                default -> throw new InvalidPieceCodeException(pieceCode);
            };

            Position position = parsePosition(positionCode);
            return factory.createPiece(pieceType, position);
        }
        throw new InvalidInputFormatException(entry);
    }

    private static Position parsePosition(String positionCode) {
        char column = positionCode.charAt(0);
        int row = Character.getNumericValue(positionCode.charAt(1));
        int x = column - 'A' + 1;
        int y = row;
        return new Position(x, y);
    }
}
