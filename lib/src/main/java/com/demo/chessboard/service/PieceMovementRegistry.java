package com.demo.chessboard.service;

import com.demo.chessboard.enums.PieceType;
import lombok.Getter;

import java.util.EnumMap;
import java.util.Map;

public class PieceMovementRegistry {

    @Getter
    private static final PieceMovementRegistry instance = new PieceMovementRegistry();

    private final Map<PieceType, MovementService> movementMap;

    private PieceMovementRegistry() {
        movementMap = new EnumMap<>(PieceType.class);
    }

    public synchronized void register(PieceType type, MovementService service) {
        movementMap.put(type, service);
    }

    public MovementService get(PieceType type) {
        return movementMap.get(type);
    }
}
