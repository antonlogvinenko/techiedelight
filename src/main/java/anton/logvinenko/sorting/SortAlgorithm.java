package anton.logvinenko.sorting;

public abstract class SortAlgorithm {

	public abstract void sort(int[] a);

	static void swap(int[] a, int i, int j) {
		int c = a[i];
		a[i] = a[j];
		a[j] = c;
	}
}
