package com.demo.chessboard.move;

import com.demo.chessboard.entity.base.Piece;
import com.demo.chessboard.entity.base.Position;
import com.demo.chessboard.entity.ChessBoard;

import java.util.HashSet;
import java.util.Set;

public class QueenMovement implements MovementService {
    @Override
    public Set<Position> calculateAvailableMoves(ChessBoard board, Piece piece) {
        Set<Position> moves = new HashSet<>();

        // Combine Rook and Bishop moves
        moves.addAll(new RookMovement().calculateAvailableMoves(board, piece));
        moves.addAll(new BishopMovement().calculateAvailableMoves(board, piece));

        return moves;
    }
}
