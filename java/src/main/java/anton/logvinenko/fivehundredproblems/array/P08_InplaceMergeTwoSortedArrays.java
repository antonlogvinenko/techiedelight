package anton.logvinenko.fivehundredproblems.array;

import static anton.logvinenko.fivehundredproblems.array.Util.print;
import static anton.logvinenko.fivehundredproblems.array.Util.swap;

public class P08_InplaceMergeTwoSortedArrays {

	/*
	1, 4, 5, 9
	7, 8, 15
	 */
	static void mergeMNComplexity(int[] a, int[] b) {
		int al = a.length;
		int bl = b.length;

		for (int i = 0; i < al; i++) {
			int ai = a[i];
			int b0 = b[0];
			if (b0 < ai) {
				swap(a, i, b, 0);
				for (int j = 0; j < bl - 1; j++) {
					if (b[j] > b[j + 1]) {
						swap(b, j, j + 1);
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		int[] a = new int[]{1, 4, 100, 900};
		int[] b = new int[]{0, 7, 8, 15};

		mergeMNComplexity(a, b);

		print(a);
		print(b);
	}
}
