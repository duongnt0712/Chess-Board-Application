package com.demo.chessboard.service.impl;

import com.demo.chessboard.entity.base.Piece;
import com.demo.chessboard.entity.base.Position;
import com.demo.chessboard.enums.Side;
import com.demo.chessboard.service.ChessBoard;
import com.demo.chessboard.service.MovementService;
import com.demo.chessboard.utils.PositionHelper;

import java.util.HashSet;
import java.util.Set;

public class PawnMovement implements MovementService {

    @Override
    public Set<Position> calculateAvailableMoves(ChessBoard board, Piece piece) {
        Set<Position> moves = new HashSet<>();
        Position currentPosition = piece.getPosition();
        int direction = piece.getSide() == Side.WHITE ? 1 : -1;

        // Forward move
        Position forward = PositionHelper.move(currentPosition, 0, direction);
        if (board.isEmpty(forward)) {
            moves.add(forward);

            // Double move from initial position
            if (PositionHelper.isInitialPosition(piece.getSide(), currentPosition)) {
                Position doubleForward = PositionHelper.move(currentPosition, 0, direction * 2);
                if (board.isEmpty(doubleForward)) {
                    moves.add(doubleForward);
                }
            }
        }

        // Captures
        for (int dx : new int[]{-1, 1}) {
            if (PositionHelper.isValidMove(currentPosition, dx, direction)) {
                Position diagonal = PositionHelper.move(currentPosition, dx, direction);
                if (board.isOccupiedByOpponent(diagonal, piece.getSide())) {
                    moves.add(diagonal);
                }
            }
        }
        return moves;
    }
}