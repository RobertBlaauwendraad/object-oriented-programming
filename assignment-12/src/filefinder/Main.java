package filefinder;

import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		try {
			String goal = "needle.txt";
			String root = "../../../ru/haystack";

			FileFinder ff = new FileFinder(root);
			long timeBefore = System.currentTimeMillis();
			ff.findFile(goal);
			long timeAfter = System.currentTimeMillis();
			long timeItTook = timeAfter - timeBefore;
			System.out.println("Parallel Run: " + timeItTook + " ms");

			FileFinder ff2 = new FileFinder(root, goal);
			Thread thread = new Thread(ff2);
			long timeBefore2 = System.currentTimeMillis();
			thread.start();
			long timeAfter2 = System.currentTimeMillis();
			long timeItTook2 = timeAfter2 - timeBefore2;
			System.out.println("Sequential Run: " + timeItTook2 + " ms");

			// Parallel Run: 100 ms
			// Sequential Run: most of the time 0 ms, sometimes between 1 and 4 ms
			// Amount of cores: 8
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
