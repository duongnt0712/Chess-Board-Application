package com.demo.chessboard.service;

import com.demo.chessboard.entity.base.Piece;
import com.demo.chessboard.entity.base.Position;
import com.demo.chessboard.enums.Side;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ChessBoard {
    private static final int BOARD_SIZE = 8;
    private final Map<Position, Piece> board;

    public ChessBoard() {
        this.board = new HashMap<>();
    }

    public boolean isValidPosition(Position position) {
        return position.file().getValue() >= 0 && position.file().getValue() < BOARD_SIZE &&
                position.rank().getValue() >= 0 && position.rank().getValue() < BOARD_SIZE;
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

    public void movePiece(Position from, Position to) {
        Piece piece = board.remove(from);
        if (piece != null) {
            piece.setPosition(to);
            board.put(to, piece);
        }
    }

    public Piece getPiece(Position position) {
        return board.get(position);
    }

    public Set<Piece> getAllPieces() {
        return Set.copyOf(board.values());
    }
}
