package anton.logvinenko.sorting;

/**
 * Array: [[0] [1 2 3 4 5]]
 * <p>
 * Find the smallest element E in the second partition,
 * swap it with the last element L in the first partition
 * if L > E
 * <p>
 * Shrink the second partition from the right side, repeat.
 */
public class SelectionSort extends SortAlgorithm {

	@Override
	public void sort(int[] a) {
		for (int i = 1; i < a.length; i++) {
			int minimal = a[i];
			int minimalIndex = i;

			for (int j = i; j < a.length; j++) {
				if (a[j] < minimal) {
					minimal = a[j];
					minimalIndex = j;
				}
			}

			if (a[i - 1] > minimal) {
				swap(a, i - 1, minimalIndex);
			}
		}
	}
}
