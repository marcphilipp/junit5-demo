package com.example.extensions;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

class TemporaryDirectoryTest {

    @Test
    @ExtendWith(TemporaryDirectoryExtension.class)
    void writeAndReadFile(Path tempDir) throws Exception {
        Path testFile = tempDir.resolve("test.txt");

        Files.write(testFile, asList("foo", "bar"));

        List<String> actualLines = Files.readAllLines(testFile);
        assertIterableEquals(asList("foo", "bar"), actualLines);
    }

}
