package anton.logvinenko;

import anton.logvinenko.sorting.*;
import anton.logvinenko.sorting.lulz.BubbleSortShort;
import anton.logvinenko.sorting.lulz.QuickSortShort;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import static java.lang.Integer.MIN_VALUE;
import static java.lang.String.format;
import static java.lang.System.currentTimeMillis;

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
		Random rand = new Random(currentTimeMillis());
		int length = 100;

		Stream<SortAlgorithm> ss = sortsAlgorithms.stream().map(x -> {
			try {
				return x.newInstance();
			} catch (InstantiationException | IllegalAccessException e) {
				throw new RuntimeException(e);
			}
		});

		ss.forEach(algorithm -> {
			boolean passed = true;
			for (int i = 0; i < 100; i++) {
				int[] unsorted = rand.ints().limit(length).toArray();
				algorithm.sort(unsorted);
				validate(unsorted);
				passed = passed && validate(unsorted);
				if (!passed) break;
			}
			System.out.println(String.format("%s\t\t%s", algorithm.getClass().getSimpleName(), passed ? "passed" : "failed"));
		});
	}
}
