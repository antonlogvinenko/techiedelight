package anton.logvinenko.fivehundredproblems.array;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

public class P06_FindMaxLengthSubArrayWithEqualNumberOf0sAnd1s {

	/**
	 * find subarray with 0 sum
	 *  - non zero sum
	 *  - largest sub array
	 *  - all subarrays
	 *
	 *  find largest subarray with equal amount of 0s and 1s
	 *    can be turned into:
	 *  find largest subarray with zero sum
	 *    by replacing 0s with -1s
	 */
	static Pair<Integer, Integer> findSubArray(int[] a) {
		Map<Integer, Integer> sums = new HashMap<>();
		int currentLength = 0;
		int start = -1, end = -1;
		sums.put(0, -1);
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			int c = a[i] == 0 ? -1 : 1;
			sum += c;
			System.out.println(sum);
			if (sums.containsKey(sum)) {
				int newStart = sums.get(sum);
				int newLength = i - newStart;
				if (newLength > currentLength) {
					currentLength = newLength;
					start = newStart + 1;
					end = i;
				}
			}
			if (!sums.containsKey(sum)) {
				sums.put(sum, i);
			}
		}
		return currentLength == 0 ? null : new Pair<>(start, end);
	}

	public static void main(String[] args) {
		int[] a = new int[]{0, 0, 1, 0, 0, 1, 0, 1, 1, 1, 0, 0, 0, 0};
		//0-9
		System.out.println(findSubArray(a));
	}
}
