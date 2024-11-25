package com.demo.chessboard.service;

import com.demo.chessboard.entity.ChessBoard;
import com.demo.chessboard.entity.base.Piece;
import com.demo.chessboard.entity.base.Position;
import com.demo.chessboard.enums.PieceType;
import com.demo.chessboard.move.MovementService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class PieceMovementRegistryTest {
    private PieceMovementRegistry registry;

    static class TestMovementService implements MovementService {
        @Override
        public Set<Position> calculateAvailableMoves(ChessBoard board, Piece piece) {
            return Set.of();
        }
    }

    @BeforeEach
    void setUp() {
        registry = PieceMovementRegistry.getInstance();
    }

    @Test
    void testSingletonInstance() {
        PieceMovementRegistry instance1 = PieceMovementRegistry.getInstance();
        PieceMovementRegistry instance2 = PieceMovementRegistry.getInstance();
        assertSame(instance1, instance2, "Expected same singleton instance for PieceMovementRegistry");
    }

    @Test
    void testRegisterAndRetrieveMovementService() {
        MovementService movementService = new TestMovementService();
        registry.register(PieceType.PAWN, movementService);

        MovementService retrievedService = registry.get(PieceType.PAWN);
        assertNotNull(retrievedService, "Expected non-null MovementService for PAWN");
        assertEquals(movementService, retrievedService, "Expected registered MovementService to match retrieved service");
    }

    @Test
    void testRetrieveUnregisteredServiceReturnsNull() {
        assertNull(registry.get(PieceType.BISHOP), "Expected null for unregistered PieceType BISHOP");
    }
}
