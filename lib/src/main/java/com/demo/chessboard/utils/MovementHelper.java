package com.demo.chessboard.utils;

import com.demo.chessboard.entity.base.Piece;
import com.demo.chessboard.entity.base.Position;
import com.demo.chessboard.service.ChessBoard;

import java.util.Set;

public class MovementHelper {

    private MovementHelper() {
        throw new IllegalStateException("Utility class");
    }

    public static void moveCrossShape(ChessBoard board, Piece piece, int[][] directions, Position currentPosition, Set<Position> moves) {
        for (int[] direction : directions) {
            int fileDirection = 0;
            int rankDirection = 0;

            while (true) {
                fileDirection += direction[0];
                rankDirection += direction[1];
                if (!PositionHelper.isValidPosition(currentPosition, fileDirection, rankDirection)) break;

                Position newPosition = PositionHelper.move(currentPosition, fileDirection, rankDirection);

                if (board.isEmpty(newPosition)) {
                    moves.add(newPosition);
                    continue;
                }

                if (board.isOccupiedByOpponent(newPosition, piece.getSide())) {
                    moves.add(newPosition);
                }
                break;
            }
        }
    }

    public static void addValidMoveOrCapture(ChessBoard board, Piece piece, int horizontalSteps, int verticalSteps, Position currentPosition, Set<Position> moves) {
        if ( !PositionHelper.isValidPosition(currentPosition, horizontalSteps, verticalSteps) ) {
            return;
        }
        Position newPosition = PositionHelper.move(currentPosition, horizontalSteps, verticalSteps);
        if (board.isEmpty(newPosition) || board.isOccupiedByOpponent(newPosition, piece.getSide())) {
            moves.add(newPosition);
        }
    }
}
