package anton.logvinenko;

import anton.logvinenko.sorting.*;
import anton.logvinenko.sorting.lulz.BubbleSortShort;
import anton.logvinenko.sorting.lulz.QuickSortShort;

import java.util.*;

import static java.lang.Integer.MIN_VALUE;
import static java.lang.String.format;

/**
 * Hello world!
 */
public class AllSortsOfSorts {

	private static final List<Class<? extends SortAlgorithm>> sortsAlgorithms =
			new ArrayList<>();

	static {
		sortsAlgorithms.add(InsertionSort.class);
		sortsAlgorithms.add(SelectionSort.class);
		sortsAlgorithms.add(ShellSort.class);
		sortsAlgorithms.add(BubbleSortOptimization1.class);
		sortsAlgorithms.add(BubbleSortOptimization2.class);
		sortsAlgorithms.add(BubbleSortOptimization2Generalized.class);
		sortsAlgorithms.add(BubbleSortAllOptimizations.class);
		sortsAlgorithms.add(BubbleSort.class);
		sortsAlgorithms.add(QuickSort.class);
		sortsAlgorithms.add(QuickSortShort.class);
		sortsAlgorithms.add(BubbleSortShort.class);
	}

	public static void print(int[] array) {
		for (int a : array) {
			System.out.println(format("%s ", a));
		}
	}

	private static boolean validate(int[] array) {
		int last = MIN_VALUE;
		for (int i = 0; i < array.length; i++) {
			if (array[i] < last) {
				return false;
			}
			last = array[i];
		}
		return true;
	}

	public static void main(String[] args) {
		Map<Integer, String> m = new HashMap<>();
		m.put(3, "c");
		m.put(2, "b");
		m.put(1, "a");
		m.put(4, "d");
		System.out.println(m.values());
	}
}
