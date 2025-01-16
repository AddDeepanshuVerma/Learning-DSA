package POTD_LEETCODE.Array;

import java.util.Arrays;

class FindThePrefixCommonArray_2657 {
    public static void main(String[] args) {
        int[] A = {1, 3, 2, 4}, B = {3, 1, 2, 4};
        int[] ans = findThePrefixCommonArray(A, B);
        System.out.println("ans = " + Arrays.toString(ans));
    }

    public static int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] count = new int[n + 1], ans = new int[n];
        int repeat = 0;

        /*for (int i = 0; i < n; i++) {
            count[A[i]]++;
            count[B[i]]++;
            if (count[A[i]] == 2) {
                repeat++;
            }
            if (A[i] != B[i] &&count[B[i]] == 2) {
                repeat++;
            }
            ans[i] = repeat;
        }*/

        for (int i = 0; i < n; i++) {
            count[A[i]]++;
            if (count[A[i]] == 2) repeat++;
            count[B[i]]++;
            if (count[B[i]] == 2) repeat++;
            ans[i] = repeat;
        }
        return ans;
    }

    public static int[] findThePrefixCommonArray2(int[] A, int[] B) {
        int n = A.length, repeat = 0;
        int[] count = new int[n + 1], ans = new int[n];

        for (int i = 0; i < n; i++) {
            if (++count[A[i]] == 2) repeat++;
            if (++count[B[i]] == 2) repeat++;
            ans[i] = repeat;
        }
        return ans;
    }
}