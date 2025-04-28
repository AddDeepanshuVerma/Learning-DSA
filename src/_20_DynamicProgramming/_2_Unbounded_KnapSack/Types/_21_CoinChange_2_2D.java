package _20_DynamicProgramming._2_Unbounded_KnapSack.Types;

class _21_CoinChange_2_2D {
    public static void main(String[] args) {
        System.out.println(count(new int[]{1, 2, 3, 5}, 5));
    }

    public static int count(int[] coins, int sum) {
        int[][] t = new int[coins.length + 1][sum + 1];

        for (int currSum = 0; currSum < sum + 1; currSum++) {
            int currVal = coins[0];
            t[1][currSum] = currSum % currVal == 0 ? currSum / currVal : Integer.MAX_VALUE - 1;
        }

        for (int i = 2; i < coins.length + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                int exclude = t[i - 1][j];

                int include = Integer.MAX_VALUE - 1;
                if (coins[i - 1] <= j) {
                    include = t[i][j - coins[i - 1]];
                }
                t[i][j] = Math.min(exclude, 1 + include);
            }
        }
        return t[coins.length][sum] == Integer.MAX_VALUE - 1 ? -1 : t[coins.length][sum];
    }
}