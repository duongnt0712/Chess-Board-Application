package com.demo.chessboard.move;

import com.demo.chessboard.entity.base.Piece;
import com.demo.chessboard.entity.base.Position;
import com.demo.chessboard.enums.Side;
import com.demo.chessboard.entity.ChessBoard;
import com.demo.chessboard.utils.PositionHelper;

import java.util.HashSet;
import java.util.Set;

public class PawnMovement implements MovementService {

    @Override
    public Set<Position> calculateAvailableMoves(ChessBoard board, Piece piece) {
        Set<Position> moves = new HashSet<>();
        Position currentPosition = piece.getPosition();
        int direction = piece.getSide() == Side.WHITE ? 1 : -1;

        handleForwardMoves(board, piece, currentPosition, direction, moves);
        handleCaptureMoves(board, piece, currentPosition, direction, moves);
        return moves;
    }

    private void handleCaptureMoves(ChessBoard board, Piece piece, Position currentPosition, int direction, Set<Position> moves) {
        int[] pawnMovement = {-1, 1};

        for (int dx : pawnMovement) {
            if (!PositionHelper.isValidPosition(currentPosition, dx, direction)) {
                continue;
            }
            Position diagonal = PositionHelper.move(currentPosition, dx, direction);
            if (board.isOccupiedByOpponent(diagonal, piece.getSide())) {
                moves.add(diagonal);
            }
        }
    }

    private void handleForwardMoves(ChessBoard board, Piece piece, Position currentPosition, int direction, Set<Position> moves) {
        // Forward move
        Position forward = PositionHelper.move(currentPosition, 0, direction);
        if (!board.isEmpty(forward)) {
            return;
        }
        moves.add(forward);

        // Double move from initial position
        if (!PositionHelper.isInitialPosition(piece.getSide(), currentPosition)) {
            return;
        }
        Position doubleForward = PositionHelper.move(currentPosition, 0, direction * 2);
        if (board.isEmpty(doubleForward)) {
            moves.add(doubleForward);
        }
    }
}