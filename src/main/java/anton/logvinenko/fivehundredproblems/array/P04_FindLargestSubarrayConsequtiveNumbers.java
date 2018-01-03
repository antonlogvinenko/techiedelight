package anton.logvinenko.fivehundredproblems.array;

import javafx.util.Pair;

public class P04_FindLargestSubarrayConsequtiveNumbers {

	static Pair<Integer, Integer> largestSubArrayOfConsecutiveNumbers(int[] aa) {
		int globalStart = 0;
		int globalLength = 0;

		int currentStart = 0;
		int currentValue = 0;
		int currentLength = 0;
		for (int i = 0; i < aa.length; i++) {
			int c = aa[i];
			if (c == currentValue + 1) {
				currentValue = c;
				currentLength++;
			} else {
				if (currentLength > globalLength) {
					globalLength = currentLength;
					globalStart = currentStart;
				}
				currentStart = i;
				currentValue = c;
				currentLength = 1;
			}
		}
		return currentLength > globalLength ?
				new Pair<>(currentStart, currentLength) :
				new Pair<>(globalStart, globalLength);
	}

	Pair<Integer, Integer> largestSubArrayOfEqualNumbers(int[] aa) {
		int largestStart = 0;
		int largestLength = 0;

		int currentValue = 0;
		int currentLength = 0;
		int currentStart = 0;
		for (int i = 0; i < aa.length; i++) {
			int a = aa[i];
			if (a != currentValue) {
				if (currentLength > largestLength) {
					largestLength = currentLength;
					largestStart = currentStart;
				}
				currentStart = i;
				currentValue = a;
				currentLength = 1;
			} else {
				currentLength++;
			}
		}
		return currentLength > largestLength ?
				new Pair<>(currentStart, currentLength) :
				new Pair<>(largestStart, largestStart);
	}

	public static void main(String[] args) {
		int c[] = new int[]{1, 4, 4, 4, 4, 5, 6, 5, 7, 7, 7};
		System.out.println(largestSubArrayOfConsecutiveNumbers(c));
	}
}
