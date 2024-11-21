package com.demo.chessboard.service;
import com.demo.chessboard.entity.base.Position;
import com.demo.chessboard.entity.base.Piece;
import com.demo.chessboard.enums.PieceType;
import com.demo.chessboard.service.impl.*;
import com.demo.chessboard.utils.PieceHelper;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Convert the input data to the right piece format
 */
public class PieceMovementService {

    private PieceMovementService() {
    }

    public static PieceMovementService createPieceMovementService() {
        return new PieceMovementService();
    }

    public Map<Piece, Set<Position>> initializeAndCalculateMoves (String input) {
        Map<Piece, Set<Position>> resultSet = new HashMap<>();

        ChessBoard board = PieceHelper.parseInput(input);

        PieceMovementRegistry registry = getPieceMovementRegistry();

        for (Piece piece : board.getAllPieces()) {
            MovementService calculator = registry.get(piece.getType());
            Set<Position> moves = calculator.calculateAvailableMoves(board, piece);
            resultSet.put(piece, moves);
        }
        return resultSet;
    }

    private static PieceMovementRegistry getPieceMovementRegistry() {
        PieceMovementRegistry registry = PieceMovementRegistry.getInstance();
        registry.register(PieceType.BISHOP, new BishopMovement());
        registry.register(PieceType.KING, new KingMovement());
        registry.register(PieceType.KNIGHT, new KnightMovement());
        registry.register(PieceType.PAWN, new PawnMovement());
        registry.register(PieceType.QUEEN, new QueenMovement());
        registry.register(PieceType.ROOK, new RookMovement());
        return registry;
    }
}
