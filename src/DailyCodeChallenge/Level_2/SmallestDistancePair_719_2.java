package DailyCodeChallenge.Level_2;

import java.util.Arrays;
import java.util.PriorityQueue;

class SmallestDistancePair_719_2 {

    public static void main(String[] args) {
        int[] nums = {1,3,1};
        int k = 1;
        SmallestDistancePair_719_2 obj = new SmallestDistancePair_719_2();
        System.out.println(obj.smallestDistancePair(nums, k));
    }

    public int smallestDistancePair(int[] nums, int k) {

        int start = 0;
        int end = Arrays.stream(nums).max().orElse(Integer.MAX_VALUE);
        int ans = -1;
        while (start <= end) {
            int mid = start + end >>> 1;
            if (totalPair(nums, mid) >= k) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }

    private int totalPair(int[] nums, int mid) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int diff = Math.abs(nums[i] - nums[j]);
                if (diff <= mid) count++;
            }
        }
        return count;
    }
}