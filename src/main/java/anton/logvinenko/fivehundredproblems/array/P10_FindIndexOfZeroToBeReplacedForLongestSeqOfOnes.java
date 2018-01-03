package anton.logvinenko.fivehundredproblems.array;

public class P10_FindIndexOfZeroToBeReplacedForLongestSeqOfOnes {

    public static void main(String[] args) {
        int[] a = new int[]{0, 0, 1, 0, 1, 1, 1, 0, 1, 1};
        System.out.println(findIndexTririvial(a));
    }

    private static int findIndexTririvial(int[] a) {
        int lastZeroIndex = 0;
        int currentSequenceLength = 0;

        int bestZeroIndex = 0;
        int longestSequenceLength = 0;

        for (int i = 0; i < a.length; i++) {
            if (a[i] == 1) {
                currentSequenceLength++;
            } else {
                currentSequenceLength = i - lastZeroIndex;
                lastZeroIndex = i;
            }

            if (currentSequenceLength > longestSequenceLength) {
                bestZeroIndex = lastZeroIndex;
            }
        }

        return bestZeroIndex;
    }
}
