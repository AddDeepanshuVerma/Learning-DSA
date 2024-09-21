package _17_SlidingWindow.easy_medium;

import java.util.ArrayList;
import java.util.List;

class MaximumSumSubarray_gfg {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(List.of(100, 200, 300, 400));
        long ans = MaximumSumSubarray_gfg.maximumSumSubarray(2, list, list.size());
        System.out.println("ans = " + ans);
    }

    static long maximumSumSubarray(int K, ArrayList<Integer> Arr, int N) {
        int i = 0;
        long ans = 0L, sum = 0L;
        for (int j = 0; j < N; j++) {
            sum += Arr.get(j);

            if (j - i + 1 == K) {
                ans = Math.max(ans, sum);
                sum -= Arr.get(i++);
            }

        }
        return ans;
    }
}