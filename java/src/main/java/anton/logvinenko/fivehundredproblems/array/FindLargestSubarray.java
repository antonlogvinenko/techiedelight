package anton.logvinenko.fivehundredproblems.array;

import static org.junit.Assert.assertArrayEquals;

/**
 * http://www.techiedelight.com/maximum-subarray-problem-kadanes-algorithm/
 */
public class FindLargestSubarray implements Runnable {

	@Override
	public void run() {
		int[] a = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
		assertArrayEquals(new int[]{3, 6, 6}, findMaxSubarray(a));
	}

	private int[] findMaxSubarray(int[] a) {
		int sum = 0;
		int minSum = -1;
		int minSumIndex = -1;

		int start= -1;
		int end = -1;
		int length = -1;

		for (int i = 0; i < a.length; i++) {
			sum += a[i];
			System.out.println(sum);
			if (sum < minSum) {
				minSum = sum;
				minSumIndex = i;
			}
			int diff = sum - minSum;
			if (diff > length) {
				start = minSumIndex + 1;
				end = i;
				length = diff;
			}
		}

		return new int[] {start, end, length};
	}
}
