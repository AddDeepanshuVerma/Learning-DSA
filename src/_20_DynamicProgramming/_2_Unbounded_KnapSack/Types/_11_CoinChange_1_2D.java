package _20_DynamicProgramming._2_Unbounded_KnapSack.Types;

class _11_CoinChange_1_2D {
    public static void main(String[] args) {
        System.out.println(count(new int[]{1, 2, 3}, 4));
    }

    public static int count(int[] coins, int sum) {
        int[][] t = new int[coins.length + 1][sum + 1];

        for (int row = 0; row < t.length; row++) {
            t[row][0] = 1;
        }

        for (int i = 1; i < coins.length + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                int exclude = t[i - 1][j];

                int include = 0;
                if (coins[i - 1] <= j) {
                    include = t[i][j - coins[i - 1]];
                }
                t[i][j] = exclude + include;
            }
        }
        return t[coins.length][sum];
    }
}