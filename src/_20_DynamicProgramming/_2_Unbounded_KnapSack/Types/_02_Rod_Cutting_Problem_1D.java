package _20_DynamicProgramming._2_Unbounded_KnapSack.Types;

import java.util.Arrays;

public class _02_Rod_Cutting_Problem_1D {
    public static void main(String[] args) {
        int[] price = {42, 68, 35, 1, 70};
        System.out.println(cutRod(price, 5));
    }

    // Easy to understand
    public static int cutRod(int[] price, int n) {
        int[] t = new int[n + 1];
        int[] length = new int[n];
        for (int i = 0; i < length.length; i++) length[i] = i + 1;
        // base cond'n : value at column 0 need to be zero as rod size is 0

        for (int i = 0; i < price.length; i++) {
            for (int j = 0; j < n + 1; j++) {
                int exclude = t[j];

                int include = 0;
                if (length[i] <= j) {
                    include = price[i] + t[j - length[i]];
                }

                t[j] = Math.max(exclude, include);
            }
        }
        System.out.println(Arrays.toString(t));
        return t[n];
    }

    // unnecessary  optimized
    public static int cutRod2(int[] price, int n) {
        int[] t = new int[n + 1];
        // base cond'n : all values for column 0 need to be zero as rod size is 0

        for (int i = 0; i < price.length; i++) {
            for (int j = 0; j < n + 1; j++) {
                int exclude = t[j];

                int include = 0;
                if ((i + 1) <= j) {
                    include = price[i] + t[j - (i + 1)];
                }

                t[j] = Math.max(exclude, include);
            }
        }
        System.out.println(Arrays.toString(t));
        return t[n];
    }

}