package com.demo.chessboard.enums;

import com.demo.chessboard.exceptions.InvalidFileException;

public enum File {
    A(1),
    B(2),
    C(3),
    D(4),
    E(5),
    F(6),
    G(7),
    H(8);

    private final int value;

    File(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return this.name();
    }

    public static File toFile(char value) {
        switch (Character.toUpperCase(value)) {
            case 'A': return A;
            case 'B': return B;
            case 'C': return C;
            case 'D': return D;
            case 'E': return E;
            case 'F': return F;
            case 'G': return G;
            case 'H': return H;
            default: throw new InvalidFileException(value);
        }
    }

    public static File toFile(int value) {
        for (File file : File.values()) {
            if (file.getValue() == value) {
                return file;
            }
        }
        throw new InvalidFileException(value);
    }

    public static File move(File file, int steps) {
        return File.toFile(file.getValue() + steps);
    }
}
