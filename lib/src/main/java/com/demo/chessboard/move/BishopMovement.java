package com.demo.chessboard.move;

import com.demo.chessboard.entity.base.Piece;
import com.demo.chessboard.entity.base.Position;
import com.demo.chessboard.entity.ChessBoard;
import com.demo.chessboard.utils.MovementHelper;

import java.util.HashSet;
import java.util.Set;

public class BishopMovement implements Movement {

    @Override
    public Set<Position> calculateAvailableMoves(ChessBoard board, Piece piece) {
        Set<Position> moves = new HashSet<>();
        Position currentPosition = piece.getPosition();

        int[][] directions = { {1, 1}, {1, -1}, {-1, 1}, {-1, -1} };

        MovementHelper.moveCrossShape(board, piece, directions, currentPosition, moves);
        return moves;
    }


}
