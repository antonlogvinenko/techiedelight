package anton.logvinenko.sorting;


/**
 * For every pass
 * if left region of some size is sorted
 * then skip all left region except its right most element in the next step
 * (because its rightmost element may swap with new neighbour)
 */
public class BubbleSortOptimization1 extends SortAlgorithm {

	@Override
	public void sort(int[] a) {
		boolean sorted = false;
		int p = 0;
		while (!sorted) {
			sorted = true;
			for (int i = p; i < a.length - 1; i++) {
				if (a[i] > a[i + 1]) {
					swap(a, i, i + 1);
					if (sorted) {
						p = i > 0 ? i - 1 : 0;
					}
					sorted = false;
				}
			}
		}
	}
}
