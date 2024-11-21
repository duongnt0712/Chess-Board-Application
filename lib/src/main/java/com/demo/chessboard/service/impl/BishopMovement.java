package com.demo.chessboard.service.impl;

import com.demo.chessboard.entity.base.Piece;
import com.demo.chessboard.entity.base.Position;
import com.demo.chessboard.service.ChessBoard;
import com.demo.chessboard.service.MovementService;
import com.demo.chessboard.utils.PositionHelper;

import java.util.HashSet;
import java.util.Set;

public class BishopMovement implements MovementService {
    @Override
    public Set<Position> calculateAvailableMoves(ChessBoard board, Piece piece) {
        Set<Position> moves = new HashSet<>();
        Position currentPosition = piece.getPosition();

        int[][] directions = { {1, 1}, {1, -1}, {-1, 1}, {-1, -1} };

        for (int[] direction : directions) {
            int fileDirection = 0;
            int rankDirection = 0;

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
        return moves;
    }
}
