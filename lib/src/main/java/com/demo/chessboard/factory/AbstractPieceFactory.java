package com.demo.chessboard.factory;

import com.demo.chessboard.entity.base.Position;
import com.demo.chessboard.entity.base.Piece;
import com.demo.chessboard.enums.PieceType;

public interface AbstractPieceFactory {
    Piece createPiece(PieceType type, Position position);
}
