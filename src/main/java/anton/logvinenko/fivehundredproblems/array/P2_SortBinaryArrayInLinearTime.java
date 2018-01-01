package anton.logvinenko.fivehundredproblems.array;

import static anton.logvinenko.fivehundredproblems.array.Util.swap;

public class P2_SortBinaryArrayInLinearTime {


	// 0 0 0 0 0 0 0 1 1 1 1 0
	static void sort(int[] a) {
		int z = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] == 0) {
				swap(a, i, z);
				z++;
			}
		}
	}

	public static void main(String[] args) {
		int[] a = new int[]{0, 1, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 0};
		sort(a);

		Util.print(a);
	}
}
