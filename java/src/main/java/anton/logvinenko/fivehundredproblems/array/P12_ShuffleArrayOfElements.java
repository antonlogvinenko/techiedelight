package anton.logvinenko.fivehundredproblems.array;

import java.util.Random;

/**
 * https://en.wikipedia.org/wiki/Fisher%E2%80%93Yates_shuffle
 */
public class P12_ShuffleArrayOfElements {
	public static void main(String[] args) {
		int[] a = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		shuffleLTR(a);
		Util.print(a);
	}

	private static void shuffleRTL(int[] array) {
		Random r = new Random();
		int n = array.length;

		for (int i = n - 1; i > 0; i--) {
			int j = r.nextInt(i); //[0, i)
			Util.swap(array, i, j);
		}
	}

	private static void shuffleLTR(int[] array) {
		Random r = new Random();
		int n = array.length;

		for (int i = 0; i < n - 1; i++) {
			// (i, n - 1]     -n -> (i-n, -1]     (* -1) -> [1, n-i)      -1 -> [0, n-i-1)
			int j = -r.nextInt(n - i - 1) - 1 + n;
			Util.swap(array, i, j);
		}
	}
}
