package Contest.Weekly_Contest._419;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Q1 {
    public static void main(String[] args) {
        Q1 obj = new Q1();
        int[] arr = {1, 1, 2, 2, 3, 4, 2, 3};
        int[] xSum = obj.findXSum(arr, 6, 2);
        System.out.println(Arrays.toString(xSum));
    }

    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];

        // find all possible subArrays of length k

        int sum = 0, i = 0;
        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];

            if (j - i + 1 == k) {
                int sub_sum = findSum(nums, i, j, sum, k, x);
                ans[i] = sub_sum;
                sum -= nums[i++];
            }
        }
        return ans;
    }

    private int findSum(int[] nums, int i, int j, int sum, int k, int x) {
        if (x == k) return sum;
        // create a map for the occurance of elements in array
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int p = i; p <= j; p++) {
            map.merge(nums[p], 1, Integer::sum);
        }
        // that if an array has less than x distinct elements, its x-sum is the sum of the array.
        if (map.size() < x) return sum;

        // calculate occurance of top x elements
        PriorityQueue<Integer> pq = new PriorityQueue<>(
                (a, b) -> map.get(a).equals(map.get(b)) ? b - a : map.get(b) - map.get(a));

//        for (int p = i; p <= j; p++) {
//            pq.add(nums[p]);
//        }
        pq.addAll(map.keySet());

        int ans = 0;
        while (x > 0) {
            int poll = pq.poll();
            ans += poll * map.get(poll);
            x--;
        }
        return ans;
    }


}
