package com.demo.chessboard.service.impl;

import com.demo.chessboard.entity.base.Piece;
import com.demo.chessboard.entity.base.Position;
import com.demo.chessboard.enums.File;
import com.demo.chessboard.enums.Rank;
import com.demo.chessboard.service.ChessBoard;
import com.demo.chessboard.service.MovementService;

import java.util.HashSet;
import java.util.Set;

public class BishopMovement implements MovementService {
    @Override
    public Set<Position> calculateAvailableMoves(ChessBoard board, Piece piece) {
        Set<Position> moves = new HashSet<>();
        Position currentPosition = piece.getPosition();

        int[][] directions = {{1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        for (int[] direction : directions) {
            int file = currentPosition.file().getValue();
            int rank = currentPosition.rank().getValue();

            while (true) {
                file += direction[0];
                rank += direction[1];
                if (file < 1 || rank < 1 || file > 8 || rank > 8 ) break;
                Position pos = new Position(File.toFile(file), Rank.toRank(rank));
                if (!board.isValidPosition(pos)) break;
                if (board.isEmpty(pos)) {
                    moves.add(pos);
                } else {
                    if (board.isOccupiedByOpponent(pos, piece.getSide())) {
                        moves.add(pos);
                    }
                    break;
                }
            }
        }
        return moves;
    }
}
