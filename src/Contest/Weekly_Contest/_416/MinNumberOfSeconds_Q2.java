package Contest.Weekly_Contest._416;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class MinNumberOfSeconds_Q2 {
    public static void main(String[] args) {
        MinNumberOfSeconds_Q2 obj = new MinNumberOfSeconds_Q2();
        int[] arr = {2, 1, 1};
        System.out.println(obj.minNumberOfSeconds(4, arr));
    }
    public long minNumberOfSeconds(int H, int[] worker) {
        long n = worker.length;
        long eachOne = H / n;
        long remaining = H % n;
        List<Long> ans = new ArrayList<>();

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int j : worker) pq.add(j);

        if (eachOne > 0) {
            long nSum = (eachOne * (eachOne + 1)) >>> 1;
            for (int j : worker) ans.add(j * nSum);
        }

        if (remaining > 0) {
            long nSum = (++eachOne * (eachOne + 1)) >>> 1;
            for (int i = 0; i < remaining; i++) {
                ans.add(pq.poll() * nSum);
            }
        }

        System.out.println("ans = " + ans);

        long minTimeNeeded = 0;
        for (int i = 0; i < ans.size(); i++) {
            minTimeNeeded = Math.max(ans.get(i), minTimeNeeded);
        }

        return minTimeNeeded;
    }
}