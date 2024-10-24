package com.demo.chessboard.service;

import com.demo.chessboard.entity.base.Piece;
import com.demo.chessboard.entity.base.Position;
import com.demo.chessboard.enums.Side;
import com.demo.chessboard.exceptions.PositionNotAvailableException;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ChessBoard {
    private final Map<Position, Piece> board = new HashMap<>();

    public void addPiece(Piece piece) {
        if (board.containsKey(piece.getPosition())) {
            throw new PositionNotAvailableException(piece.getPosition());
        }
        board.put(piece.getPosition(), piece);
    }

    public Set<Piece> getAllPieces() {
        return Set.copyOf(board.values());
    }
}
