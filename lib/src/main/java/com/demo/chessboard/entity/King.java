package com.demo.chessboard.entity;

import com.demo.chessboard.entity.base.Piece;
import com.demo.chessboard.entity.base.Position;
import com.demo.chessboard.enums.PieceType;
import com.demo.chessboard.enums.Side;
import lombok.Builder;

public class King extends Piece  {

    @Builder
    public King(Side side, Position position) {
        super(PieceType.KING, side, position);
    }
}
