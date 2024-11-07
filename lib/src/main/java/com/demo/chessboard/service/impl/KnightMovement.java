package com.demo.chessboard.service.impl;

import com.demo.chessboard.entity.base.Piece;
import com.demo.chessboard.entity.base.Position;
import com.demo.chessboard.service.ChessBoard;
import com.demo.chessboard.service.MovementService;

import java.util.Set;

public class KnightMovement implements MovementService {
    @Override
    public Set<Position> calculateAvailableMoves(ChessBoard board, Piece piece) {
        return Set.of();
    }
}
