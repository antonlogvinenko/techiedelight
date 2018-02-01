package anton.logvinenko.fivehundredproblems.array;

import static org.junit.Assert.assertArrayEquals;

/**
 * http://www.techiedelight.com/move-zeros-present-array-end/
 */
public class MoveAllZerosPresentToTheEnd implements Runnable {

	private void moveZerosToEnd(int[] a) {
		int z = -1;
		for (int i = 0; i < a.length; i++) {
			int c = a[i];
			if (c == 0 && z == -1) {
				z = i;
				continue;
			}
			if (c != 0 && z != -1) {
				Util.swap(a, i, z);
				z++;
			}
		}
	}

	@Override
	public void run() {
		int[] a = new int[]{6, 0, 8, 2, 3, 0, 4, 0, 1};
		moveZerosToEnd(a);
		assertArrayEquals(new int[]{6, 8, 2, 3, 4, 1, 0, 0, 0}, a);
	}
}
