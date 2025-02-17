package POTD_LEETCODE.Array;

import jdk.jfr.Description;

import java.util.ArrayDeque;
import java.util.Stack;

class FinalPrices_1475 {
    @Description("Bruteforce n^2 approach")
    public int[] finalPrices(int[] prices) {
        for (int i = 0; i < prices.length; i++) {
            prices[i] -= getLower(i, prices[i], prices);
        }

        return prices;
    }

    private int getLower(int index, int upto, int[] prices) {
        for (int j = index + 1; j < prices.length; j++) {
            if (prices[j] <= upto) return prices[j];
        }
        return 0;
    }

    @Description("Optimal approach: n")
    public int[] finalPrices2(int[] prices) {
        int n = prices.length;
        int[] ans = prices.clone();

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() > prices[i]) {
                stack.pop();
            }
            ans[i] = stack.isEmpty() ? ans[i] : ans[i] - stack.peek();
            stack.push(prices[i]);
        }
        return ans;
    }

}