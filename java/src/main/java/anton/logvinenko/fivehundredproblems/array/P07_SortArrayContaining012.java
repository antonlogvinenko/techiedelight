package anton.logvinenko.fivehundredproblems.array;


import static anton.logvinenko.fivehundredproblems.array.Util.print;

public class P07_SortArrayContaining012 {
	///0 0 0 [1] 1 1 1 [2] 2 2 2 (0)

	///0 0 0 0 [2] 2 2 2 2 (0) 2
	static void sort012(int[] a) {
		int r0 = 0;
		int r1 = 0;
		for (int i = 0; i < a.length; i++) {
			int c = a[i];
			if (c == 1) {
				Util.swap(a, i, r1);
				r1++;
			} else if (c == 0) {
				Util.swap(a, i, r1);
				Util.swap(a, r1, r0);
				r0++;
				r1++;
			}
		}
	}

	public static void main(String[] args) {
		int b[] = new int[]{2, 0, 0, 0, 2, 2, 1, 0, 2, 0, 1, 2, 0, 1, 1};
		sort012(b);
		print(b);
	}
}
