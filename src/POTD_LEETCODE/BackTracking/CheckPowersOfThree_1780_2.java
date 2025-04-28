package POTD_LEETCODE.BackTracking;

import java.util.Arrays;

class CheckPowersOfThree_1780_2 {
    static final int[] arr;

    static {
        arr = new int[16];
        arr[0] = 1;
        for (int i = 1; i < 16; i++) {
            arr[i] = arr[i - 1] * 3;
        }
    }

    public static boolean checkPowersOfThree(int n) {
        int currSum = 0, index = 0;
        return dfs(arr.length - 1, currSum, n);
    }

    private static boolean dfs(int i, int currSum, int target) {
        if (currSum == target) return true;

        if (i < 0 || currSum > target) {
            return false;
        }

        return dfs(i - 1, currSum, target) || dfs(i - 1, currSum + arr[i], target);
    }

    public static void main(String[] args) {
        boolean ans = checkPowersOfThree(90);
        System.out.println("ans = " + ans);
        System.out.println("arr = " + Arrays.toString(arr));
    }
}