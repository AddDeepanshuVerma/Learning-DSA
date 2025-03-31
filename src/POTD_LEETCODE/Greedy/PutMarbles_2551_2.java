package POTD_LEETCODE.Greedy;

import java.util.Arrays;

class PutMarbles_2551_2 {
    public long putMarbles(int[] weights, int k) {
        int[] pairSum = new int[weights.length - 1];

        int n = pairSum.length;
        for (int i = 0; i < n; i++) {
            pairSum[i] = weights[i] + weights[i + 1];
        }
        Arrays.sort(pairSum);

        long ans = 0;
        for (int i = 0; i < n && --k > 0; i++) {
            ans += pairSum[n - i - 1] - pairSum[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        var obj = new PutMarbles_2551_2();
        int[] weights = {1, 3, 5, 1};
        int k = 2;
        System.out.println(obj.putMarbles(weights, k));
    }
}