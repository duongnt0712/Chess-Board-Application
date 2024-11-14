package com.demo.chessboard.enums;

import com.demo.chessboard.exceptions.InvalidFileException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
    void testToFileValidCases() {
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
    void testToFileInvalidCases() {
        assertThrows(InvalidFileException.class, () -> File.toFile('K'), "Expected InvalidFileException for input 'K'");
        assertThrows(InvalidFileException.class, () -> File.toFile('1'), "Expected InvalidFileException for input '1'");
        assertThrows(InvalidFileException.class, () -> File.toFile('!'), "Expected InvalidFileException for input '!'");
    }
}
