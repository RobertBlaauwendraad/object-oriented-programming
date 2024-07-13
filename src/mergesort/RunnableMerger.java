package mergesort;

import java.util.Arrays;

public class RunnableMerger implements Runnable {
	private final int[] array;

	public RunnableMerger(int[] array) {
		this.array = array;
	}

	@Override
	public void run() {
		if (array.length > 10000) {
			try {
				int[] firstHalf = Arrays.copyOf(array, array.length / 2);
				int[] secondHalf = Arrays.copyOfRange(array, array.length / 2, array.length);
				RunnableMerger first = new RunnableMerger(firstHalf);
				RunnableMerger second = new RunnableMerger(secondHalf);
				Thread thread1 = new Thread(first);
				Thread thread2 = new Thread(second);
				thread1.start();
				thread2.start();
				thread1.join();
				thread2.join();
				MergeSort.merge(firstHalf, secondHalf, array);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		} else {
			MergeSort.sort(array);
		}
	}
}
