package com.demo.chessboard.entity.base;

import com.demo.chessboard.enums.PieceType;
import com.demo.chessboard.enums.Side;
import com.demo.chessboard.service.ChessBoard;
import lombok.*;

import java.util.Set;

@Data
@AllArgsConstructor
public abstract class Piece {
    private PieceType type;
    private Side side;
    private Position position;

    public abstract Set<Position> calculateAvailableMoves(ChessBoard board);
}