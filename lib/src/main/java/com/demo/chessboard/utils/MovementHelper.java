package com.demo.chessboard.utils;

import com.demo.chessboard.entity.base.Piece;
import com.demo.chessboard.entity.base.Position;
import com.demo.chessboard.service.ChessBoard;

import java.util.Set;

public class MovementHelper {

    private MovementHelper() {
        throw new IllegalStateException("Utility class");
    }

    public static void moveCrossShape(ChessBoard board, Piece piece, int[] direction, int fileDirection, int rankDirection, Position currentPosition, Set<Position> moves) {
        while (true) {
            fileDirection += direction[0];
            rankDirection += direction[1];
            if ( !PositionHelper.isValidMove(currentPosition, fileDirection, rankDirection) ) break;

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
