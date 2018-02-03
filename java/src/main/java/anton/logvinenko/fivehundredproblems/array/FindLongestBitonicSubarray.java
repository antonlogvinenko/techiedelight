package anton.logvinenko.fivehundredproblems.array;

import static org.junit.Assert.assertArrayEquals;

public class FindLongestBitonicSubarray implements Runnable {

	@Override
	public void run() {//   0  1  2  3  4  5  6   7  8  9  10
		int[] a = new int[]{3, 5, 8, 4, 5, 9, 10, 8, 5, 3, 4};
		int[] result2 = findLongestBitonicSubarrayApproach(a);
		assertArrayEquals(new int[]{3, 7}, result2);
	}

	private int[] findLongestBitonicSubarrayApproach(int[] a) {
		int i = 0;
		int maxStart = 0;
		int maxLength = 0;
		int n = a.length;

		while (i < n - 1) {
			int length = 1;
			int start = i;

			while (i < n - 1 && a[i + 1] > a[i]) {
				length++;
				i++;
			}

			while (i < n - 1 && a[i + 1] < a[i]) {
				length++;
				i++;
			}

			if (length > maxLength) {
				maxLength = length;
				maxStart = start;
			}
		}

		return new int[]{maxStart, maxLength};
	}
}
