package com.example.extensions;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ExtensionContext.Namespace;
import org.junit.jupiter.api.extension.ExtensionContext.Store;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;
import org.junit.jupiter.api.extension.TestExtensionContext;

public class TemporaryDirectoryExtension implements ParameterResolver, AfterEachCallback {

    public static final String ROOT = "root";

    @Override
    public boolean supports(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return parameterContext.getParameter().getType().equals(Path.class);
    }

    @Override
    public Object resolve(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return getStore(extensionContext).getOrComputeIfAbsent(ROOT, key -> createTempDir());
    }

    @Override
    public void afterEach(TestExtensionContext context) throws Exception {
        Path root = getStore(context).get(ROOT, Path.class);
        if (root != null) {
            deleteRecursively(root);
        }
    }

    private void deleteRecursively(Path root) throws IOException {
        Files.walkFileTree(root, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                Files.delete(file);
                return super.visitFile(file, attrs);
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                Files.delete(dir);
                return super.postVisitDirectory(dir, exc);
            }
        });
    }

    private Store getStore(ExtensionContext extensionContext) {
        return extensionContext.getStore(Namespace.create("tempDir", extensionContext.getUniqueId()));
    }

    private Path createTempDir() {
        try {
            return Files.createTempDirectory("junit");
        } catch (IOException e) {
            throw new ParameterResolutionException("Could not create temp dir", e);
        }
    }
}
