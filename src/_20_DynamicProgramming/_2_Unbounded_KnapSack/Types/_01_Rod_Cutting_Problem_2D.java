package _20_DynamicProgramming._2_Unbounded_KnapSack.Types;

import java.util.Arrays;

public class _01_Rod_Cutting_Problem_2D {
    public static void main(String[] args) {
        int[] price = {42, 68, 35, 1, 70};
        System.out.println(cutRod2(price, 5));
    }

	// to understand the problem where changing curr problem to knapSack problem
	public static int cutRod(int[] val, int capacity) {
		int n = val.length;
		int[][] t = new int[n + 1][capacity + 1];

		// base cond'n : all values for column 0 need to be zero as rod size is 0

		int[] wt = new int[capacity];
		for (int i = 0; i < wt.length; i++) wt[i] = i + 1;

		for (int i = 1; i < n + 1; i++) {
			for (int j = 0; j < capacity + 1; j++) {
				int exclude = t[i - 1][j];

				int include = 0;
				if (wt[i - 1] <= j) {
					include = val[i - 1] + t[i][j - wt[i - 1]];
				}

				t[i][j] = Math.max(exclude, include);
			}
		}
		for (int[] ints : t) System.out.println(Arrays.toString(ints));
		return t[n][capacity];
	}

	// converting this problem to its given variable naming
    public static int cutRod2(int[] price, int n) {
        int[][] t = new int[price.length + 1][n + 1];
        int[] length = new int[n];
        for (int i = 0; i < length.length; i++) length[i] = i + 1;
        // base cond'n : all values for column 0 need to be zero as rod size is 0

        for (int i = 1; i < price.length + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                int exclude = t[i - 1][j];

                int include = 0;
                if (length[i - 1] <= j) {  // if current length is less than current knapsack capacity then we can include it + add its price
                    include = price[i - 1] + t[i][j - length[i - 1]];
                }

                t[i][j] = Math.max(exclude, include);
            }
        }
        for (int[] ints : t) System.out.println(Arrays.toString(ints));
        return t[price.length][n];
    }

	// optimized sol
    public static int cutRod3(int[] price, int n) {
        int[][] t = new int[price.length + 1][n + 1];
        // base cond'n : all values for column 0 need to be zero as rod size is 0

        for (int i = 1; i < price.length + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                int exclude = t[i - 1][j];

                int include = 0;
                if (i <= j) {
                    include = price[i - 1] + t[i][j - i];
                }

                t[i][j] = Math.max(exclude, include);
            }
        }
        for (int[] ints : t) System.out.println(Arrays.toString(ints));
        return t[price.length][n];
    }
}