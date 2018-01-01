package anton.logvinenko.fivehundredproblems.array;

public class P11_FindMaximumProductInArray {

	private static int maxProduct(int[] a) {
		int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;
		int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;

		for (int c : a) {
			if (c > max1) {
				max2 = max1;
				max1 = c;
			} else if (c > max2) {
				max2 = c;
			}
			if (c < min1) {
				min2 = min1;
				min1 = c;
			} else if (c < min2) {
				min2 = c;
			}
		}

		return Math.max(max1 * max2, min1 * min2);
	}

	public static void main(String[] args) {
		int[] a = new int[]{0, -10, 5, -6, 7, -30, 50, 19, 8, -8};

		System.out.println(maxProduct(a));
	}
}
