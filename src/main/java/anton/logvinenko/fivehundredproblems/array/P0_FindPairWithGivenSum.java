package anton.logvinenko.fivehundredproblems.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * http://www.techiedelight.com/find-pair-with-given-sum-array/
 */
public class P0_FindPairWithGivenSum {

	public static void main(String[] args) {
		int a[] = new int[]{9, 5, 7, 9, 6, 3, 2, 7, 0, 43};
		int p = 9;

//		System.out.println(findNaive(a));
		System.out.println(findWithSort(a, p));
		System.out.println(findAllPairsWithSort(a, p));
//		System.out.println(findWithHash(a));
	}

	private static int findWithHash(int[] a) {
		return 0;
	}

	private static List<Integer> findWithSort(int[] a, int p) {
		Arrays.sort(a);

		int i = a.length - 1, j = 0;
		while (i > j) {
			int x = a[i];
			int y = a[j];

			int sum = x + y;
			if (sum == p) {
				return List.of(i, j);
			}
			if (sum > p) {
				i--;
			} else {
				j++;
			}
		}
		return null;
	}

	private static List<List<Integer>> findAllPairsWithSort(int[] a, int p) {
		Arrays.sort(a);
		List<List<Integer>> allPairs = new ArrayList<>();
		int i = a.length - 1, j = 0;
		while (i > j) {
			int x = a[i];
			int y = a[j];
			int sum = x + y;
			if (sum == p) {
				allPairs.add(List.of(x, y));
			}
			if (sum > p) {
				i--;
			} else {
				j++;
			}
		}
		return allPairs;
	}

	private static int findNaive(int[] a) {
		return 0;
	}

	private static int findWithHashMap(int[] a) {
		return 0;
	}
}
