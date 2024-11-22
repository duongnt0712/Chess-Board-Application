package com.demo.chessboard.service.impl;

import com.demo.chessboard.entity.base.Piece;
import com.demo.chessboard.entity.base.Position;
import com.demo.chessboard.service.ChessBoard;
import com.demo.chessboard.service.MovementService;
import com.demo.chessboard.utils.MovementHelper;
import com.demo.chessboard.utils.PositionHelper;

import java.util.HashSet;
import java.util.Set;

public class KingMovement implements MovementService {
    @Override
    public Set<Position> calculateAvailableMoves(ChessBoard board, Piece piece) {
        Set<Position> moves = new HashSet<>();
        Position currentPosition = piece.getPosition();

        int[] deltas = {-1, 0, 1};

        for (int dx : deltas) {
            for (int dy : deltas) {
                // Skip the current position
                if (dx == 0 && dy == 0) continue;

                MovementHelper.addValidMoveOrCapture(board, piece, dx, dy, currentPosition, moves);
            }
        }

        return moves;
    }
}
