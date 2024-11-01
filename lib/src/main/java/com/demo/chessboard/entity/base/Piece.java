package com.demo.chessboard.entity.base;

import com.demo.chessboard.enums.PieceType;
import com.demo.chessboard.enums.Side;
import lombok.*;

@Data
@AllArgsConstructor
public abstract class Piece {
    private PieceType type;
    private Side side;
    private Position position;
}