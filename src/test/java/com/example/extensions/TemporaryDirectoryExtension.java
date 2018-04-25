package com.example.extensions;

import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

import static org.junit.jupiter.api.extension.ExtensionContext.Namespace.GLOBAL;

public class TemporaryDirectoryExtension implements ParameterResolver, AfterEachCallback {
    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return parameterContext.getParameter().getType().equals(Path.class);
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return extensionContext.getStore(GLOBAL)
                .getOrComputeIfAbsent("tempDir", key -> createTempDir());
    }

    @Override
    public void afterEach(ExtensionContext context) throws IOException {
        Path tempDir = context.getStore(GLOBAL).get("tempDir", Path.class);
        if (tempDir != null) {
            deleteRecursively(tempDir);
        }
    }

    private void deleteRecursively(Path tempDir) throws IOException {
        Files.walkFileTree(tempDir, new SimpleFileVisitor<>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                System.out.println("Deleting file: " + file);
                Files.delete(file);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                System.out.println("Deleting dir: " + dir);
                Files.delete(dir);
                return FileVisitResult.CONTINUE;
            }
        });
    }

    private Path createTempDir() {
        try {
            return Files.createTempDirectory("junit");
        } catch (IOException e) {
            throw new ParameterResolutionException("Could not create temp dir", e);
        }
    }
}
