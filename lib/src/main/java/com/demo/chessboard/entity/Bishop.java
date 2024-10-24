package com.demo.chessboard.entity;

import com.demo.chessboard.entity.base.Piece;
import com.demo.chessboard.entity.base.Position;
import com.demo.chessboard.enums.PieceType;
import com.demo.chessboard.enums.Side;
import com.demo.chessboard.service.ChessBoard;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

public class Bishop extends Piece {

    @Builder
    public Bishop(Side side, Position position) {
        super(PieceType.BISHOP, side, position);
    }

    @Override
    public Set<Position> calculateAvailableMoves(ChessBoard board) {
        Set<Position> moves = new HashSet<>();
        // TODO: add move strategy
        return moves;
    }
}
