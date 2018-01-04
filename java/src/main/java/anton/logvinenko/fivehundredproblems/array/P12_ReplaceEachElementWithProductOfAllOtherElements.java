package anton.logvinenko.fivehundredproblems.array;

public class P12_ReplaceEachElementWithProductOfAllOtherElements {

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 5};
        int[] b = new int[]{1, 2, 3, 4, 5};

        findWithAdditionalSpace(a);
        Util.print(a);

        findRecursively(b);
        Util.print(b);
    }

    /**
     * Receives product of a[0]...a[i-1] as `leftProduct` argument
     * Returns product of a[i]...a[n-1]
     * Sets a[i]
     */
    private static int recursion(int[] a, int i, int leftProduct) {
        if (i == a.length) {
            return 1;
        }
        int rightProduct = recursion(a, i + 1, leftProduct * a[i]);
        int current = a[i];
        a[i] = leftProduct * rightProduct;
        return current * rightProduct;
    }

    private static void findRecursively(int[] a) {
        recursion(a, 0, 1);
    }


    // 1 2 3 4 5 //input
    // 1 1 2 6 24 //left
    // 120 60 20 5 1 //right
    // 120 60 40 30 24 //output

    /**
     * left[i] is product of a[i] for i in [0..i-1]
     * right[i] is product of a[i] for i in [i+1..n-1]
     * a[i] must be set to left[i] * right [i] then
     */
    private static void findWithAdditionalSpace(int[] a) {
        int left[] = new int[a.length];
        int right[] = new int[a.length];

        left[0] = 1;
        for (int i = 1; i < left.length; i++) {
            left[i] = left[i - 1] * a[i - 1];
        }

        right[right.length - 1] = 1;
        for (int i = right.length - 2; i >= 0; i--) {
            right[i] = right[i + 1] * a[i + 1];
        }

        for (int i = 0; i < a.length; i++) {
            a[i] = left[i] * right[i];
        }
    }
}
