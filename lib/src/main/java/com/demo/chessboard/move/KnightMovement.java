package com.demo.chessboard.move;

import com.demo.chessboard.entity.base.Piece;
import com.demo.chessboard.entity.base.Position;
import com.demo.chessboard.entity.ChessBoard;
import com.demo.chessboard.utils.MovementHelper;

import java.util.HashSet;
import java.util.Set;

public class KnightMovement implements Movement {
    @Override
    public Set<Position> calculateAvailableMoves(ChessBoard board, Piece piece) {
        Set<Position> moves = new HashSet<>();
        Position currentPosition = piece.getPosition();

        int[][] knightMoves = {
                {2, 1}, {2, -1}, {-2, 1}, {-2, -1},
                {1, 2}, {1, -2}, {-1, 2}, {-1, -2}
        };

        for (int[] move : knightMoves) {
            MovementHelper.addValidMoveOrCapture(board, piece, move[0], move[1], currentPosition, moves);
        }
        return moves;
    }

}
