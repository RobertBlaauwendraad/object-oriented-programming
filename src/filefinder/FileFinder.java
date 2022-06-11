package filefinder;

import java.io.File;
import java.io.IOException;

public class FileFinder implements Runnable {
	private final File rootDir;
	private String filename;

	public FileFinder(String root) throws IOException {
		rootDir = new File(root);
		if (!(rootDir.exists() && rootDir.isDirectory())) {
			throw new IOException(root + " is not a directory");
		}
	}

	public FileFinder(String root, String filename) throws IOException {
		rootDir = new File(root);
		this.filename = filename;
		if (!(rootDir.exists() && rootDir.isDirectory())) {
			throw new IOException(root + " is not a directory");
		}
	}

	public void findFile(String file) {
		find(rootDir, file);
	}

	private void find(File rootDir, String fileName) {
		File[] files = rootDir.listFiles();
		if (files != null) {
			for (File file : files) {
				if (file.getName().equals(fileName)) {
					System.out.println("Found at: " + file.getAbsolutePath());
				} else if (file.isDirectory()) {
					find(file, fileName);
				}
			}
		}
	}

	private void findParallel(File rootDir, String filename) throws IOException {
		File[] files = rootDir.listFiles();
		if (files != null) {
			for (File file : files) {
				if (file.getName().equals(filename)) {
					System.out.println("Found at: " + file.getAbsolutePath());
				} else if (file.isDirectory()) {
					FileFinder ff = new FileFinder(file.toString(), filename);
					Thread thread = new Thread(ff);
					thread.start();
				}
			}
		}
	}

	@Override
	public void run() {
		try {
			findParallel(rootDir, filename);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
