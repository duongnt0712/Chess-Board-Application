package com.demo.chessboard.service;

import com.demo.chessboard.enums.PieceType;
import lombok.Getter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class PieceMovementRegistry {

    @Getter
    private static final PieceMovementRegistry instance = new PieceMovementRegistry();

    private final Map<PieceType, MovementService> movementMap;

    private PieceMovementRegistry() {
        movementMap = new ConcurrentHashMap<>();
    }

    public void register(PieceType type, MovementService calculator) {
        movementMap.put(type, calculator);
    }

    public MovementService getCalculator(PieceType type) {
        return movementMap.get(type);
    }
}
