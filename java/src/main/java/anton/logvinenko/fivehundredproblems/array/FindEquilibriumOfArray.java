package anton.logvinenko.fivehundredproblems.array;

import static junit.framework.Assert.assertEquals;

public class FindEquilibriumOfArray implements Runnable {

	@Override
	public void run() {
		int[] x = new int[]{0, 4, -5, 1, -1};
		int e = initialAttempt(x);
		assertEquals(3, e);
	}

	private int initialAttempt(int[] a) {
		int sum = 0;
		for (int i : a) {
			sum += i;
		}
		sum -= a[0];
		int left = 0;
		int right = sum;

		for (int i = 0; i < a.length - 1; i++) {
			left += a[i];
			right -= a[i + 1];
			if (left == right) {
				return i + 1;
			}
		}

		return -1;
	}
}
