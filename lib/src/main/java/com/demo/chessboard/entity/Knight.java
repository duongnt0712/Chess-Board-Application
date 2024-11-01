package com.demo.chessboard.entity;

import com.demo.chessboard.entity.base.Piece;
import com.demo.chessboard.entity.base.Position;
import com.demo.chessboard.enums.PieceType;
import com.demo.chessboard.enums.Side;
import lombok.Builder;

public class Knight extends Piece {

    @Builder
    public Knight(Side side, Position position) {
        super(PieceType.KNIGHT, side, position);
    }
}
