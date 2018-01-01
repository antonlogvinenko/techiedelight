package anton.logvinenko.sorting;

public class QuickSort extends SortAlgorithm {

	private int partition(int[] a, int l, int h) {
		int p = l;
		int x = a[h];

		for (int i = l; i <= h; i++) {
			if (a[i] <= x) {
				swap(a, p, i);
				p++;
			}
		}

		return p - 1;
	}

	@Override
	public void sort(int[] a) {
		int[] stack = new int[a.length];
		int top = -1;
		stack[++top] = a.length - 1;

		while (top > -1) {
			int h = stack[top--];
			int l = top == -1 ? 0 : stack[top];

			int p = partition(a, l, h);
			if (l < p - 1)
				stack[++top] = p - 1;
			if (p + 1 < h)
				stack[++top] = h;
		}
	}
}
