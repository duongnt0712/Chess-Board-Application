package com.demo.chessboard.entity;

import com.demo.chessboard.entity.base.Piece;
import com.demo.chessboard.entity.base.Position;
import com.demo.chessboard.enums.PieceType;
import com.demo.chessboard.enums.Side;
import com.demo.chessboard.service.ChessBoard;
import lombok.Builder;

import java.util.HashSet;
import java.util.Set;

public class Queen extends Piece {

    @Builder
    public Queen(Side side, Position position) {
        super(PieceType.QUEEN, side, position);
    }

    @Override
    public Set<Position> calculateAvailableMoves(ChessBoard board) {
        Set<Position> moves = new HashSet<>();
        // TODO: add move strategy
        return moves;
    }
}
