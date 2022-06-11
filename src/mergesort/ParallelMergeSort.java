package mergesort;

public class ParallelMergeSort {
	public static void sort(int[] array) {
		RunnableMerger runnableMerger = new RunnableMerger(array);
		Thread thread = new Thread(runnableMerger);
		thread.start();
		try {
			thread.join();
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}
}
