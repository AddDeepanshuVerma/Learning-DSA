package Contest.Weekly_Contest._444;

import java.util.Iterator;
import java.util.PriorityQueue;

public class Q3 {

    private PriorityQueue<Integer> pq;

    public int maxProduct(int[] nums, int k, int limit) {
        pq = new PriorityQueue<>((a, b) -> b - a);
        int idx = 0, count = 0, currSum = 0;
        int product = 1;
        dfs(idx, count, currSum, k, nums, product);

        int ans = -1;
        while (!pq.isEmpty()) {
            int poll = pq.poll();
            if (poll <= limit) {
                return poll;
            }
        }
        return -1;
    }

    private void dfs(int idx, int count, int currSum, int k, int[] nums, int product) {
        if (currSum == k) pq.add(product);
        if (idx >= nums.length) return;

        if ((count & 1) == 0) { // till now even number of items added
            dfs(idx + 1, count + 1, currSum + nums[idx], k, nums, product * nums[idx]);
        } else {
            dfs(idx + 1, count + 1, currSum - nums[idx], k, nums, product * nums[idx]);
        }

        dfs(idx + 1, count, currSum, k, nums, product);
    }

    public static void main(String[] args) {
        Q3 obj = new Q3();
        int[] nums = {0};
        int k = 0;
        int limit = 10;

        int ans = obj.maxProduct(nums, k, limit);
        System.out.println(ans);
    }
}
