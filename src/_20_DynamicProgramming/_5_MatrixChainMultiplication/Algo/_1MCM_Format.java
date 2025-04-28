package _20_DynamicProgramming._5_MatrixChainMultiplication.Algo;

public class _1MCM_Format {
    /*
     * Matrix chain multiplication explained :
     * In this type of MATRIX CHAIN MULTIPLICATION Question we are either given an Array or a String
     * And we will be having a feeling to break this string like we will take i & j pointer at first and last index
     * And we will break this Array/String at k distance which will make it (i to k) & (k+1 to j) Also
     * k will keep on increasing from i to j.
     *
     * Hence, our function will be like this that bw i & j a distance k is increasing with some constant speed and
     * for each distance we are calculating something by dividing that array/string in 2 half.
     * And when we get all k results we calculate something out of them.
     * And obviously we will be adding a base case so that i & j don't go berserk.
     *
     * Here can be multiple minor changes which will lead to diff type of questions being asked.
     * like : const speed of k being changed from k++ to k+=2
     *        our k goes till j-1 instead j
     * */

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 56, 56};
        int i = 0, j = arr.length - 1;
        int ans = matrixChainMultiplication(i, j, arr);
    }

    private static int matrixChainMultiplication(int i, int j, int[] arr) {
        if (i > j) { // base case
            // some calculations                                    // here changes can be made like >=
            return 0;
        }

        int ans = Integer.MIN_VALUE;
        for (int k = i + 1; k < j; k++) {                           // here change can reflect on how k increments
            int left = matrixChainMultiplication(i, k, arr);
            int right = matrixChainMultiplication(k + 1, j, arr);
            ans = Math.max(ans, Math.min(left, right));             // here changes can be introduced
        }
        return ans;
    }

}
