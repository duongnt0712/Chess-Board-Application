package com.demo.chessboard.entity;

import com.demo.chessboard.entity.base.Piece;
import com.demo.chessboard.entity.base.Position;
import com.demo.chessboard.enums.PieceType;
import com.demo.chessboard.enums.Side;
import lombok.Builder;

public class Queen extends Piece {

    @Builder
    public Queen(Side side, Position position) {
        super(PieceType.QUEEN, side, position);
    }
}
