package com.demo.chessboard.service;

import com.demo.chessboard.enums.PieceType;
import com.demo.chessboard.move.MovementService;

import java.util.EnumMap;
import java.util.Map;

public class PieceMovementRegistry {

    private final Map<PieceType, MovementService> movementMap;

    private PieceMovementRegistry() {
        movementMap = new EnumMap<>(PieceType.class);
    }

    private static class SingletonHelper {
        private static final PieceMovementRegistry INSTANCE = new PieceMovementRegistry();
    }

    public static PieceMovementRegistry getInstance() {
        return SingletonHelper.INSTANCE;
    }

    public synchronized void register(PieceType type, MovementService service) {
        movementMap.put(type, service);
    }

    public MovementService get(PieceType type) {
        return movementMap.get(type);
    }
}
