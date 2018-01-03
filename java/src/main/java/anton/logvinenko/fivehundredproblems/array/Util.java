package anton.logvinenko.fivehundredproblems.array;

class Util {
	static void swap(int[] a, int i, int j) {
		int x = a[i];
		a[i] = a[j];
		a[j] = x;
	}

	static void swap(int[] a, int ai, int[] b, int bj) {
		int x = a[ai];
		a[ai] = b[bj];
		b[bj] = x;
	}

	static void print(int[] a) {
		for (int av : a) {
			System.out.print(av);
			System.out.print(" ");
		}
		System.out.println();
	}
}
