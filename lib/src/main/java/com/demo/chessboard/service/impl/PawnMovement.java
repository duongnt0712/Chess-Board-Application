package com.demo.chessboard.service.impl;

import com.demo.chessboard.entity.base.Piece;
import com.demo.chessboard.entity.base.Position;
import com.demo.chessboard.service.ChessBoard;
import com.demo.chessboard.service.MovementService;

import java.util.HashSet;
import java.util.Set;

public class PawnMovement implements MovementService {

    @Override
    public Set<Position> calculateAvailableMoves(ChessBoard board, Piece piece) {
        Set<Position> moves = new HashSet<>();
        moves.add(new Position(piece.getPosition().file(), piece.getPosition().rank())); // Add rank 1 step ahead
        return moves;
    }
}