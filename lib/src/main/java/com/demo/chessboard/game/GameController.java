package com.demo.chessboard.game;
import com.demo.chessboard.entity.ChessBoard;
import com.demo.chessboard.entity.base.Position;
import com.demo.chessboard.entity.base.Piece;
import com.demo.chessboard.enums.PieceType;
import com.demo.chessboard.move.*;
import com.demo.chessboard.utils.PieceHelper;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class GameController {

    private GameController() {
    }

    public static GameController createGameController() {
        return new GameController();
    }

    public Map<Piece, Set<Position>> initializeAndCalculateMoves (String[] input) {
        Map<Piece, Set<Position>> resultSet = new HashMap<>();

        ChessBoard board = PieceHelper.parseInput(input);

        PieceMovementRegistry registry = getPieceMovementRegistry();

        for (Piece piece : board.getAllPieces()) {
            Movement movement = registry.get(piece.getType());
            Set<Position> moves = movement.calculateAvailableMoves(board, piece);
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
