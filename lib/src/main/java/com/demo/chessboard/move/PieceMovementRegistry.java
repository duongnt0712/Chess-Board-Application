package com.demo.chessboard.move;

import com.demo.chessboard.enums.PieceType;

import java.util.EnumMap;
import java.util.Map;

public class PieceMovementRegistry {

    private final Map<PieceType, Movement> movementMap;

    private PieceMovementRegistry() {
        movementMap = new EnumMap<>(PieceType.class);
    }

    private static class SingletonHelper {
        private static final PieceMovementRegistry INSTANCE = new PieceMovementRegistry();
    }

    public static PieceMovementRegistry getInstance() {
        return SingletonHelper.INSTANCE;
    }

    public synchronized void register(PieceType type, Movement service) {
        movementMap.put(type, service);
    }

    public Movement get(PieceType type) {
        return movementMap.get(type);
    }
}
