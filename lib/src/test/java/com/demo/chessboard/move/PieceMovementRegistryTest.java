package com.demo.chessboard.move;

import com.demo.chessboard.entity.ChessBoard;
import com.demo.chessboard.entity.base.Piece;
import com.demo.chessboard.entity.base.Position;
import com.demo.chessboard.enums.PieceType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class PieceMovementRegistryTest {
    private PieceMovementRegistry registry;

    static class TestMovement implements Movement {
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
    void testRegisterAndRetrieveMovement() {
        Movement movement = new TestMovement();
        registry.register(PieceType.PAWN, movement);

        Movement retrievedService = registry.get(PieceType.PAWN);
        assertNotNull(retrievedService, "Expected non-null MovementService for PAWN");
        assertEquals(movement, retrievedService, "Expected registered MovementService to match retrieved service");
    }

    @Test
    void testRetrieveUnregisteredMovementReturnsNull() {
        assertNull(registry.get(PieceType.BISHOP), "Expected null for unregistered PieceType BISHOP");
    }
}
