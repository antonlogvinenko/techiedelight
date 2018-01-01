package anton.logvinenko.sorting;


public class BubbleSortAllOptimizations extends SortAlgorithm {

	@Override
	public void sort(int[] a) {
		boolean sorted = false;
		int p = 0;
		int n = a.length;
		while (!sorted) {
			sorted = true;
			int newi = 0;
			for (int i = p; i < n - 1; i++) {
				if (a[i] > a[i + 1]) {
					swap(a, i, i + 1);
					if (sorted) {
						p = i > 0 ? i - 1 : 0;
					}
					sorted = false;
					newi = i + 1;
				}
			}
			n = newi;
		}
	}
}
