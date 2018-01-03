package anton.logvinenko.sorting;

/**
 * Array: [[0] [1 2 3 4 5]]
 * <p>
 * Take the leftmost element E in the second partition,
 * swap elements to find its place in the first partition.
 * <p>
 * Shrink the second partition from the left side, repeat.
 */
public class InsertionSort extends SortAlgorithm {

	@Override
	public void sort(int[] a) {
		for (int i = 1; i < a.length; i++) {

			for (int j = i; j > 0 && a[j - 1] > a[j]; j--) {
				swap(a, j - 1, j);
			}
		}
	}
}
