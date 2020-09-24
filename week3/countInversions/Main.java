class Main {
    /* In this task, you will have to count the number of inversions in an array, A. A pair of indices is called an inversion if A[i] > A[j] when i ≤ j. */

    static int countInversions(int[] A) {
        int count = 0;

        for (int i=0; i<A.length; i++) {
            for (int j=i + 1; j<A.length; j++) {
                if (A[i] > A[j]) {
                    count++;
                }
            }
        }
        return count;
    }
}
