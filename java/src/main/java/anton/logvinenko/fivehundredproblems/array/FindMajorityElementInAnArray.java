package anton.logvinenko.fivehundredproblems.array;

import static junit.framework.Assert.assertEquals;

/**
 * http://www.techiedelight.com/find-majority-element-in-an-array-boyer-moore-majority-vote-algorithm/
 * Obvious implementations:
 * 1) for each element, calculate sum, O(n^2) time
 * 2) sort and then calculate cluster length
 * 3) use hash map to calculate frequency
 */
public class FindMajorityElementInAnArray implements Runnable {

	@Override
	public void run() {
		int[] a = new int[]{2, 8, 7, 2, 2, 5, 2, 3, 1, 2, 2};
		assertEquals(2, boyerMooreAlgorithm(a));
	}

	private int boyerMooreAlgorithm(int[] a) {
		int m = 0;
		int i = 0;
		for (int j = 0; j < a.length; j++) {
			if (i == 0) {
				m = a[j];
				i = 1;
			} else if (m == a[j]) {
				i++;
			} else {
				i--;
			}
		}

		return m;
	}
}
