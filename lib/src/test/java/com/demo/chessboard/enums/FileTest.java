package com.demo.chessboard.enums;

import com.demo.chessboard.exceptions.InvalidFileException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileTest {

    @Test
    void verifyFiles() {
        assertEquals( 8, File.values().length, "Expected count for File is 8");
    }

    @Test
    void testGetValue() {
        assertEquals(1, File.A.getValue(), "Expected value for A is 1");
        assertEquals(2, File.B.getValue(), "Expected value for B is 2");
        assertEquals(3, File.C.getValue(), "Expected value for C is 3");
        assertEquals(4, File.D.getValue(), "Expected value for D is 4");
        assertEquals(5, File.E.getValue(), "Expected value for E is 5");
        assertEquals(6, File.F.getValue(), "Expected value for F is 6");
        assertEquals(7, File.G.getValue(), "Expected value for G is 7");
        assertEquals(8, File.H.getValue(), "Expected value for H is 8");
    }

    @Test
    void testToString() {
        assertEquals("A", File.A.toString(), "Expected string representation of A is 'A'");
        assertEquals("B", File.B.toString(), "Expected string representation of B is 'B'");
        assertEquals("C", File.C.toString(), "Expected string representation of C is 'C'");
        assertEquals("D", File.D.toString(), "Expected string representation of D is 'D'");
        assertEquals("E", File.E.toString(), "Expected string representation of E is 'E'");
        assertEquals("F", File.F.toString(), "Expected string representation of F is 'F'");
        assertEquals("G", File.G.toString(), "Expected string representation of G is 'G'");
        assertEquals("H", File.H.toString(), "Expected string representation of H is 'H'");
    }

    @Test
    void testToFileWithCharValidCases() {
        assertEquals(File.A, File.toFile('A'), "Expected File.A for input 'A'");
        assertEquals(File.B, File.toFile('B'), "Expected File.B for input 'B'");
        assertEquals(File.C, File.toFile('C'), "Expected File.C for input 'C'");
        assertEquals(File.D, File.toFile('D'), "Expected File.D for input 'D'");
        assertEquals(File.E, File.toFile('E'), "Expected File.E for input 'E'");
        assertEquals(File.F, File.toFile('F'), "Expected File.F for input 'F'");
        assertEquals(File.G, File.toFile('G'), "Expected File.G for input 'G'");
        assertEquals(File.H, File.toFile('H'), "Expected File.H for input 'H'");
    }

    @Test
    void testToFileWithCharInvalidCases() {
        assertThrows(InvalidFileException.class, () -> File.toFile('K'), "Expected InvalidFileException for input 'K'");
        assertThrows(InvalidFileException.class, () -> File.toFile('1'), "Expected InvalidFileException for input '1'");
        assertThrows(InvalidFileException.class, () -> File.toFile('!'), "Expected InvalidFileException for input '!'");
    }

    @Test
    void testToFileWithIntValidCases() {
        assertEquals(File.A, File.toFile(1), "Expected File.A for input 1");
        assertEquals(File.B, File.toFile(2), "Expected File.B for input 2");
        assertEquals(File.C, File.toFile(3), "Expected File.C for input 3");
        assertEquals(File.D, File.toFile(4), "Expected File.D for input 4");
        assertEquals(File.E, File.toFile(5), "Expected File.E for input 5");
        assertEquals(File.F, File.toFile(6), "Expected File.F for input 6");
        assertEquals(File.G, File.toFile(7), "Expected File.G for input 7");
        assertEquals(File.H, File.toFile(8), "Expected File.H for input 8");
    }

    @Test
    void testToFileWithIntInvalidCases() {
        assertThrows(InvalidFileException.class, () -> File.toFile(9), "Expected InvalidFileException for input 1");
        assertThrows(InvalidFileException.class, () -> File.toFile(-1), "Expected InvalidFileException for input -1");
        assertThrows(InvalidFileException.class, () -> File.toFile(0), "Expected InvalidFileException for input 0");
    }

    @Test
    void testMoveLeftValidCases() {
        assertEquals(File.B, File.moveLeft(File.A, 1), "Expected File.B when moving left 1 step from File.A");
        assertEquals(File.D, File.moveLeft(File.C, 1), "Expected File.D when moving left 1 step from File.C");
        assertEquals(File.H, File.moveLeft(File.F, 2), "Expected File.H when moving left 2 steps from File.F");
    }

    @Test
    void testMoveLeftInvalidCases() {
        assertThrows(InvalidFileException.class,
                () -> File.moveLeft(File.H, 1), "Expected InvalidFileException for invalid moving left");
        assertThrows(InvalidFileException.class,
                () -> File.moveLeft(File.E, 4), "Expected InvalidFileException for invalid moving left");
    }

    @Test
    void testMoveRightValidCases() {
        assertEquals(File.A, File.moveRight(File.B, 1), "Expected File.A when moving right 1 step from File.B");
        assertEquals(File.C, File.moveRight(File.D, 1), "Expected File.C when moving right 1 step from File.D");
        assertEquals(File.E, File.moveRight(File.G, 2), "Expected File.E when moving right 2 steps from File.G");
    }

    @Test
    void testMoveRightInvalidCases() {
        assertThrows(InvalidFileException.class,
                () -> File.moveRight(File.A, 1), "Expected InvalidFileException for invalid moving right");
        assertThrows(InvalidFileException.class,
                () -> File.moveRight(File.D, 4), "Expected InvalidFileException for invalid moving right");
    }
}
