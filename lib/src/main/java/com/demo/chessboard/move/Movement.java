package com.demo.chessboard.move;

import com.demo.chessboard.entity.ChessBoard;
import com.demo.chessboard.entity.base.Piece;
import com.demo.chessboard.entity.base.Position;

import java.util.Set;

public interface Movement {
    Set<Position> calculateAvailableMoves(ChessBoard board, Piece piece);
}
