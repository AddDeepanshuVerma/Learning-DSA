package _20_DynamicProgramming._2_Unbounded_KnapSack.Types;

// Getting TLE
class _26_CoinChange_2_Recursion {
    public static void main(String[] args) {
        int miniElements = count(new int[]{1, 2, 3}, 5);
        System.out.println(miniElements);
    }

    public static int count(int[] coins, int sum) {
        int index = 0;
        int ans = dfs(coins, index, sum);
        return ans == Integer.MAX_VALUE - 1 ? -1 : ans;
    }

    private static int dfs(int[] arr, int index, int remain) {
        if (index == arr.length || remain <= 0) {
            return remain == 0 ? 0 : Integer.MAX_VALUE - 1;
        }

        int pick = 1 + dfs(arr, index, remain - arr[index]);
        int skip = dfs(arr, index + 1, remain);

        return Math.min(pick, skip);
    }
}