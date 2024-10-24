package com.demo.chessboard.factory;

import com.demo.chessboard.entity.*;
import com.demo.chessboard.entity.base.Position;
import com.demo.chessboard.entity.base.Piece;
import com.demo.chessboard.enums.PieceType;
import com.demo.chessboard.enums.Side;

public class PieceFactory implements AbstractPieceFactory {
    private final Side side;

    public PieceFactory(Side side) {
        this.side = side;
    }

    @Override
    public Piece createPiece(PieceType type, Position position) {
        return switch (type) {
            case PAWN -> Pawn.builder().side(side).position(position).build();
            case BISHOP -> Bishop.builder().side(side).position(position).build();
            case KNIGHT -> Knight.builder().side(side).position(position).build();
            case ROOK -> Rook.builder().side(side).position(position).build();
            case QUEEN -> Queen.builder().side(side).position(position).build();
            case KING -> King.builder().side(side).position(position).build();
        };
    }
}
