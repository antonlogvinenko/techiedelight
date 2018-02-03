package anton.logvinenko.fivehundredproblems.array;

import static org.junit.Assert.assertArrayEquals;

/**
 * http://www.techiedelight.com/find-maximum-difference-between-two-elements-array/
 */
public class FindMaxDiffBetweenTwoElemsLesserBetweenLarger implements Runnable {

	@Override
	public void run() {
		int[] a = new int[]{2, 7, 9, 5, 1, 3, 5};
		assertArrayEquals(new int[]{0, 2, 7}, findMaxDiffOrdered(a));
	}

	private int[] findMaxDiffOrdered(int[] a) {
		int smallestIndex = -1;
		int smallest = Integer.MAX_VALUE;

		int largeInDiff = -1;
		int smallInDiff = -1;
		int largestDiff = -1;

		for (int i = 0; i < a.length; i++) {
			if (a[i] < smallest) {
				smallestIndex = i;
				smallest = a[i];
			}
			int diff = a[i] - smallest;
			if (diff > largestDiff) {
				smallInDiff = smallestIndex;
				largeInDiff = i;
				largestDiff = diff;
			}
		}
		return new int[]{smallInDiff, largeInDiff, largestDiff};
	}
}
