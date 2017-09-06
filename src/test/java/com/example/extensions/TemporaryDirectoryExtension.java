package com.example.extensions;

import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ExtensionContext.Namespace;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class TemporaryDirectoryExtension implements ParameterResolver, AfterEachCallback {
	@Override
	public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
		return parameterContext.getParameter().getType().equals(Path.class);
	}

	@Override
	public Path resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
		return getStore(extensionContext).getOrComputeIfAbsent("tempDir", key -> createTempDir(), Path.class);
	}

	@Override
	public void afterEach(ExtensionContext context) throws Exception {
		Path tempDir = getStore(context).get("tempDir", Path.class);
		if (tempDir != null) {
			deleteRecursively(tempDir);
		}
	}

	private ExtensionContext.Store getStore(ExtensionContext extensionContext) {
		return extensionContext.getStore(Namespace.create(TemporaryDirectoryExtension.class, extensionContext));
	}

	private Path createTempDir() {
		try {
			return Files.createTempDirectory("junit");
		} catch (IOException e) {
			throw new ParameterResolutionException("Could not create temp dir", e);
		}
	}

	private void deleteRecursively(Path root) throws IOException {
		Files.walkFileTree(root, new SimpleFileVisitor<Path>() {
			@Override
			public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
				System.out.println("deleting file " + file);
				Files.delete(file);
				return super.visitFile(file, attrs);
			}

			@Override
			public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
				System.out.println("deleting dir " + dir);
				Files.delete(dir);
				return super.postVisitDirectory(dir, exc);
			}
		});
	}

}
