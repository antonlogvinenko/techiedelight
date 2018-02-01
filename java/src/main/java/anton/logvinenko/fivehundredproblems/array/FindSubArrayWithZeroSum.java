package anton.logvinenko.fivehundredproblems.array;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static junit.framework.Assert.assertEquals;

public class FindSubArrayWithZeroSum implements Runnable {

	static Pair<Integer, Integer> findZeroSumSubArray(int[] a) {
		Map<Integer, Integer> sums = new HashMap<>();
		sums.put(0, -1);
		int sum = 0;

		for (int i = 0; i < a.length; i++) {
			sum += a[i];
			if (sums.containsKey(sum)) {
				return new Pair<>(sums.get(sum) + 1, i);
			}
			if (!sums.containsKey(sum)) {
				sums.put(sum, i);
			}
		}

		return null;
	}

	static List<Pair<Integer, Integer>> findAllZeroSumSubArrays(int[] a) {
		Map<Integer, List<Integer>> sums = new HashMap<>();
		List<Integer> zero = new ArrayList<>();
		zero.add(-1);
		sums.put(0, zero);

		int sum = 0;
		List<Pair<Integer, Integer>> results = new ArrayList<>();

		for (int i = 0; i < a.length; i++) {
			sum += a[i];
			if (sums.containsKey(sum)) {
				for (Integer begin : sums.get(sum)) {
					results.add(new Pair<>(begin + 1, i));
				}
			}
			List<Integer> sumSeenWhere = sums.getOrDefault(sum, new ArrayList<>());
			sumSeenWhere.add(i);
			sums.put(sum, sumSeenWhere);
		}

		return results;
	}

	@Override
	public void run() {
		int[] a = new int[]{4, 7, 8, -10, 5, -10, -4};
		assertEquals(new Pair<>(1, 5), findZeroSumSubArray(a));
		assertEquals(List.of(new Pair<>(1, 5), new Pair<>(0, 6)),
				findAllZeroSumSubArrays(a));
	}
}
