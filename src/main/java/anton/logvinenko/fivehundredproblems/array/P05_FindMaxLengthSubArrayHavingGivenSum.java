package anton.logvinenko.fivehundredproblems.array;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

public class P05_FindMaxLengthSubArrayHavingGivenSum {

	static Pair<Integer, Integer> findSubArray(int[] a, int expectedSum) {
		int sum = 0;
		Map<Integer, Integer> startIndex = new HashMap<>();
		startIndex.put(0, -1);

		for (int i = 0; i < a.length; i++) {
			sum += a[i];
			int probableStart = sum - expectedSum;
			if (startIndex.containsKey(probableStart)) {
				return new Pair<>(startIndex.get(probableStart) + 1, i);
			}
			if (!startIndex.containsKey(sum)) {
				startIndex.put(sum, i);
			}
		}
		return null;
	}


	//10 14 22 33 29
	public static void main(String[] args) {
		int a[] = new int[]{10, 4, -10, -4, 10, 4, 8, 11, -4, 20, 51, 8};
		System.out.println(findSubArray(a, 15));
	}
}
