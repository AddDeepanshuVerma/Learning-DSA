package _20_DynamicProgramming._2_Unbounded_KnapSack.Types;

// Getting TLE
class _25_CoinChange_2_Recursion {
    public static void main(String[] args) {
        int miniElements = count(new int[]{1, 2, 3}, 5);
        System.out.println(miniElements);
    }

    static int count;

    public static int count(int[] coins, int sum) {
        int currSum = 0, length = 0, index = 0;
        count = Integer.MAX_VALUE;
        dfs(coins, index, sum, currSum, length);
        return count == Integer.MAX_VALUE ? -1 : count;
    }

    private static void dfs(int[] arr, int index, int sum, int currSum, int len) {
        if (index == arr.length || currSum > sum) return;
        if (currSum == sum) {
            count = Math.min(count, len);
            return;
        }

        dfs(arr, index, sum, currSum + arr[index], len + 1);
        dfs(arr, index + 1, sum, currSum, len);
    }
}