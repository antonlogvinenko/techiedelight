package anton.logvinenko.fivehundredproblems.array;


/**
 * http://www.techiedelight.com/find-index-0-replaced-get-maximum-length-sequence-of-continuous-ones/
 *
 * I believe that {@link #slidingWindow} and {@link #continuousSequences}
 * are actually the same algorithm
 */
public class P10_FindIndexOfZeroToBeReplacedForLongestSeqOfOnes {

    public static void main(String[] args) {
        int[] a = new int[]{0, 0, 1, 0, 1, 1, 1, 0, 1, 1};
        System.out.println(continuousSequences(a));
        System.out.println(slidingWindow(a));
    }

    /**
     * 1) Window can have only one zero.
     *
     * 2) Window's right border is expanded to the right on each step.
     *
     * 3) When a new zero is detected the left border
     * is set to prevZeroIndex+1 to exclude the old zero.
     *
     * 3) On every step we check if current window is the largest known window.
     */
    private static int slidingWindow(int[] a) {
        int wStart = 0;
        int wEnd = 0;

        int globalZeroIndex = 0;
        int globalLength = 0;

        int currentZeroIndex = 0;
        int currentLength = 0;

        for (int i = 0; i < a.length; i++) {
            wEnd = i;
            if (a[i] == 1) {
                currentLength++;
            } else {
                wStart = currentZeroIndex + 1;
                currentLength = wEnd - wStart + 1;
                currentZeroIndex = wEnd;
            }

            if (currentLength > globalLength) {
                globalZeroIndex = currentZeroIndex;
                globalLength = currentLength;
            }
        }

        return globalZeroIndex;
    }

    /**
     * 1) A 0 is always between two clusters of 1s
     * 1 1 1 [0] 1 1 1 // left and right non empty clusters
     * 0 [0] 1 1 //left cluster of 1s is empty.
     *
     * 2) Right cluster's right border is expanded to the right.
     *
     * 3) When we encounter a new zero, right cluster becomes left,
     * we figure out its length (currentZeroIndex - prevZeroIndex)
     * and remember current zero index.
     *
     * 4) Current length is incremented if we encounter new 1s in the right cluster.
     */
    private static int continuousSequences(int[] a) {
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
                longestSequenceLength = currentSequenceLength;
            }
        }

        return bestZeroIndex;
    }
}
