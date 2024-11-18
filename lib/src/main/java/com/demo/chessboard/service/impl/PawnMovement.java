package com.demo.chessboard.service.impl;

import com.demo.chessboard.entity.base.Piece;
import com.demo.chessboard.entity.base.Position;
import com.demo.chessboard.enums.File;
import com.demo.chessboard.enums.Rank;
import com.demo.chessboard.enums.Side;
import com.demo.chessboard.service.ChessBoard;
import com.demo.chessboard.service.MovementService;

import java.util.HashSet;
import java.util.Set;

public class PawnMovement implements MovementService {

    @Override
    public Set<Position> calculateAvailableMoves(ChessBoard board, Piece piece) {
        Set<Position> moves = new HashSet<>();
        Position current = piece.getPosition();
        int direction = piece.getSide() == Side.WHITE ? 1 : -1;

        // Forward move
        Position forward = current.toBuilder().rank(Rank.toRank(current.rank().getValue() + direction)).build();
        if (board.isEmpty(forward)) {
            moves.add(forward);

            // Double move from initial position
            if ((piece.getSide() == Side.WHITE && current.rank().getValue() == 2) || (piece.getSide() == Side.BLACK && current.rank().getValue() == 7)) {
                Position doubleForward = new Position( current.file(), Rank.toRank(current.rank().getValue() + 2 * direction));
                if (board.isEmpty(doubleForward)) {
                    moves.add(doubleForward);
                }
            }
        }

        // Captures
        for (int dx : new int[]{-1, 1}) {
            int newFileValue = current.file().getValue() + dx;
            int newRankValue = current.rank().getValue() + direction;
            if (newFileValue >= 1 && newFileValue <= 8 && newRankValue >= 1 && newRankValue <= 8) {
                Position diagonal = new Position(File.toFile(newFileValue), Rank.toRank(newRankValue));
                if (board.isOccupiedByOpponent(diagonal, piece.getSide())) {
                    moves.add(diagonal);
                }
            }
        }
        return moves;
    }
}