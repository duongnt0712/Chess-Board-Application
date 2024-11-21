package com.demo.chessboard.service.impl;

import com.demo.chessboard.entity.base.Piece;
import com.demo.chessboard.entity.base.Position;
import com.demo.chessboard.service.ChessBoard;
import com.demo.chessboard.service.MovementService;
import com.demo.chessboard.utils.PositionHelper;

import java.util.HashSet;
import java.util.Set;

public class KnightMovement implements MovementService {
    @Override
    public Set<Position> calculateAvailableMoves(ChessBoard board, Piece piece) {
        Set<Position> moves = new HashSet<>();
        Position currentPosition = piece.getPosition();

        int[][] knightMoves = {
                {2, 1}, {2, -1}, {-2, 1}, {-2, -1},
                {1, 2}, {1, -2}, {-1, 2}, {-1, -2}
        };

        for (int[] move : knightMoves) {
            if ( PositionHelper.isValidMove(currentPosition, move[0], move[1]) ) {
                Position newPosition = PositionHelper.move(currentPosition, move[0], move[1]);
                if (board.isEmpty(newPosition) || board.isOccupiedByOpponent(newPosition, piece.getSide())) {
                    moves.add(newPosition);
                }
            }
        }

        return moves;
    }
}
