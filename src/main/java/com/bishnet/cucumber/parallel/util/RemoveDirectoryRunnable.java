package com.bishnet.cucumber.parallel.util;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class RemoveDirectoryRunnable implements Runnable {

	private Path dirToDelete;

	public RemoveDirectoryRunnable(Path dirToDelete) {
		this.dirToDelete = dirToDelete;
	}

	@Override
	public void run() {
		try (DirectoryStream<Path> dirStream = Files.newDirectoryStream(dirToDelete)) {
			for (Path file : dirStream)
				Files.delete(file);
			Files.delete(dirToDelete);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
