package com.demo.chessboard.entity;

import com.demo.chessboard.enums.File;
import com.demo.chessboard.exceptions.InvalidFileException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FileTest {

    @Test
    void verifyFiles() {
        assertEquals( 8, File.values().length, "Unexpected count for File");
    }

    @Test
    void shouldEqualToFile() {
        assertEquals( File.A, File.toFile('A'));
        assertEquals( File.B, File.toFile('B'));
        assertEquals( File.C, File.toFile('C'));
        assertEquals( File.D, File.toFile('D'));
        assertEquals( File.E, File.toFile('E'));
        assertEquals( File.F, File.toFile('F'));
        assertEquals( File.G, File.toFile('G'));
        assertEquals( File.H, File.toFile('H'));
    }

    @Test
    void shouldReturnInvalidFileException() {
        assertThrows(InvalidFileException.class, () -> File.toFile('K'));
    }
}
