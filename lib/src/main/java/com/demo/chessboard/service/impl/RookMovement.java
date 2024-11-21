package com.demo.chessboard.service.impl;

import com.demo.chessboard.entity.base.Piece;
import com.demo.chessboard.entity.base.Position;
import com.demo.chessboard.service.ChessBoard;
import com.demo.chessboard.service.MovementService;
import com.demo.chessboard.utils.MovementHelper;

import java.util.HashSet;
import java.util.Set;

public class RookMovement implements MovementService {
    @Override
    public Set<Position> calculateAvailableMoves(ChessBoard board, Piece piece) {
        Set<Position> moves = new HashSet<>();
        Position currentPosition = piece.getPosition();

        int[][] directions = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };

        for (int[] direction : directions) {
            int fileDirection = 0;
            int rankDirection = 0;

            MovementHelper.moveCrossShape(board, piece, direction, fileDirection, rankDirection, currentPosition, moves);
        }

        return moves;

    }
}
