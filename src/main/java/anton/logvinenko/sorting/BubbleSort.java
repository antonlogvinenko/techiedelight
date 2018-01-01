package anton.logvinenko.sorting;

/**
 * No comments
 */
public class BubbleSort extends SortAlgorithm {

	@Override
	public void sort(int[] a) {
		boolean sorted = false;
		while (!sorted) {
			sorted = true;
			for (int i = 0; i < a.length - 1; i++) {
				if (a[i] > a[i + 1]) {
					swap(a, i, i + 1);
					sorted = false;
				}
			}
		}
	}
}
