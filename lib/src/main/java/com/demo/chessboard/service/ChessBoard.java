package com.demo.chessboard.service;

import com.demo.chessboard.entity.base.Piece;
import com.demo.chessboard.entity.base.Position;
import com.demo.chessboard.enums.Side;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ChessBoard {
    private final Map<Position, Piece> board;

    public ChessBoard() {
        this.board = new HashMap<>();
    }

    public boolean isEmpty(Position position) {
        return board.get(position) == null;
    }

    public boolean isOccupiedByOpponent(Position position, Side side) {
        Piece piece = board.get(position);
        return piece != null && piece.getSide() != side;
    }

    public void addPiece(Piece piece) {
        board.put(piece.getPosition(), piece);
    }

    public Piece getPiece(Position position) {
        return board.get(position);
    }

    public Set<Piece> getAllPieces() {
        return Set.copyOf(board.values());
    }
}
