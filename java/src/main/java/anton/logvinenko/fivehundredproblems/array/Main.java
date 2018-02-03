package anton.logvinenko.fivehundredproblems.array;

import java.util.ArrayList;
import java.util.List;

public class Main {

	private static final List<Class<? extends Runnable>> algorithms =
			new ArrayList<>() {{
				add(FindPairWithGivenSum.class);
				add(FindSubArrayWithZeroSum.class);
				add(FindEquilibriumOfArray.class);
				add(FindMajorityElementInAnArray.class);
				add(MoveAllZerosPresentToTheEnd.class);
				add(ReplaceEachElementWithProductOfAllOtherElements.class);
				add(FindLongestBitonicSubarray.class);
				add(FindMaxDiffBetweenTwoElemsLesserBetweenLarger.class);
				add(FindLargestSubarray.class);
			}};

	public static void main(String[] args) throws IllegalAccessException, InstantiationException {
		for (Class<? extends Runnable> algorithm : algorithms) {
			Runnable runnableAlgorithm = algorithm.newInstance();
			runnableAlgorithm.run();
		}
	}
}
