package anton.logvinenko.sorting;


/**
 * For every pass
 * largest element bubbles up
 * so we may skip the last element
 */
public class BubbleSortOptimization2 extends SortAlgorithm {

	@Override
	public void sort(int[] a) {
		boolean sorted = false;
		int p = 1;
		int n = a.length;
		while (!sorted) {
			sorted = true;
			for (int i = 0; i < n - 1; i++) {
				if (a[i] > a[i + 1]) {
					swap(a, i, i + 1);
					sorted = false;
				}
			}
			n--;
		}
	}
}
