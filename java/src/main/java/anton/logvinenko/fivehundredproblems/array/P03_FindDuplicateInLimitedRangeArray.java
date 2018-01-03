package anton.logvinenko.fivehundredproblems.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class P03_FindDuplicateInLimitedRangeArray {

	public static void main(String[] args) {
		int[] a = new int[]{1, 3, 5, 2, 4, 5};
		System.out.println(findDuplicateByMarking(a));
		System.out.println(findDuplicateByXor(a));
		System.out.println(findDuplicateBySum(a));
		System.out.println(findDuplicateByHashing(a));
	}

	private static int findDuplicateByHashing(int[] a) {
		Set<Integer> m = new HashSet<>();
		for (int v : a) {
			if (m.contains(v)) {
				return v;
			}
			m.add(v);
		}
		return 0;
	}

	private static int findDuplicateByXor(int[] a) {
		int duplicate = 0;
		for (int i = 0; i < a.length; i++) {
			duplicate ^= i;
			duplicate ^= a[i];
		}
		return duplicate;
	}

	private static int findDuplicateBySum(int[] a) {
		int duplicate = 0;
		for (int i = 0; i < a.length; i++) {
			duplicate -= i;
			duplicate += a[i];
		}
		return duplicate;
	}

	/*
	 * 1..n-1
	 */
	private static int findDuplicateByMarking(int[] a) {
		int duplicate = -1;
		for (int i = 0; i < a.length; i++) {
			int c = Math.abs(a[i]);
			if (a[c] > 0) {
				a[c] = -a[c];
			} else {
				duplicate = c;
				break;
			}
		}

		for (int i = 0; i < a.length; i++) {
			if (a[i] < 0) {
				a[i] = -a[i];
			}
		}

		return duplicate;
	}
}
