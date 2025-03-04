package POTD_LEETCODE.BackTracking;

import java.util.HashMap;

class CheckPowersOfThree_1780_memo {
    static final int[] arr;
    private static HashMap<String, Boolean> dp;

    static {
        arr = new int[16];
        arr[0] = 1;
        for (int i = 1; i < 16; i++) {
            arr[i] = arr[i - 1] * 3;
        }
    }

    public static boolean checkPowersOfThree(int n) {
        int target = n, currSum = 0, index = 0;
        dp = new HashMap<>();
        return dfs(0, currSum, target);
    }

    private static boolean dfs(int i, int currSum, int target) {
        if (currSum == target) {
            return true;
        }
        if (i >= arr.length || currSum > target) {
            return false;
        }
        String key = String.valueOf(i) + currSum;
        if (dp.containsKey(key)) {
            return dp.get(key);
        }

        boolean res = dfs(i + 1, currSum, target) || dfs(i + 1, currSum + arr[i], target);
        dp.put(key, res);
        return res;
    }

    public static void main(String[] args) {
        boolean ans = checkPowersOfThree(90);
        System.out.println("ans = " + ans);
    }
}