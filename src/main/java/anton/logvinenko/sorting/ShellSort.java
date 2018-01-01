package anton.logvinenko.sorting;

/**
 * 1. Start with big enough step h < array.length
 * 2. Use insertion sort algorithm to sort array of each h-s element
 * 3. Decrease h, goto 2
 */
public class ShellSort extends SortAlgorithm {

	@Override
	public void sort(int[] a) {
		int n = a.length;

		int h = 1;
		while (h < n) {
			h = 3 * h + 1;
		}

		while (h > 0) {
			for (int i = h; i < n; i += h) {
				for (int j = i; j > 0 && a[j - 1] > a[j]; j--) {
					swap(a, j - 1, j);
				}
			}

			h /= 3;
		}
	}
}
