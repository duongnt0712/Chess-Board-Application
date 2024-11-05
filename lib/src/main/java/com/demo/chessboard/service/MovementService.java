package com.demo.chessboard.service;

import com.demo.chessboard.entity.base.Piece;
import com.demo.chessboard.entity.base.Position;

import java.util.Set;

public interface MovementService {
    Set<Position> calculateAvailableMoves(ChessBoard board, Piece piece);
}
