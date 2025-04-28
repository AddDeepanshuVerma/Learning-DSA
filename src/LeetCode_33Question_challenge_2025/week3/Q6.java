package LeetCode_33Question_challenge_2025.week3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Q6 {
    public static long numberOfSubsequences(int[] nums) {
        long count = 0;
        int n = nums.length;
        for (int p = 0; p < n; p++) {
            for (int q = p + 2; q < n; q++) {
                for (int r = q + 2; r < n; r++) {
                    for (int s = r + 2; s < n; s++) {
                        if (nums[p] * nums[r] == nums[q] * nums[s]) {
                            System.out.println(nums[p] + " " + nums[r] + " " + nums[q] + " " + nums[s]);
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }

    public static long numberOfSubsequences2(int[] nums) {
        HashMap<Double, ArrayList<Integer>> map = new HashMap<>();
        int n = nums.length;
        for (int p = 0; p < n; p++) {
            for (int q = p + 2; q < n; q++) {
                double key = nums[p] / (double) nums[q];
                map.computeIfAbsent(key, val -> new ArrayList<>()).add(q);
            }
        }
        map.values().forEach(Collections::sort);

        long count = 0;
        for (int r = 4; r < n; r++) {
            for (int s = r + 2; s < n; s++) {
                double key = nums[s] / (double) nums[r];
                // now for this key, find all those indexes which are <= r - 2
                if (map.containsKey(key)) {
                    ArrayList<Integer> list = map.get(key);
                    // find number of values in this list which are <= r - 2
                    count += binarySearch(list, r - 2);
                }
            }
        }

        return count;
    }

    private static long binarySearch(ArrayList<Integer> list, int target) {
        int start = 0, end = list.size() - 1;
        int ans = -1;
        while (start <= end) {
            int mid = (start + end) >>> 1;
            if (list.get(mid) <= target) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
//        return ans == -1 ? 0 : ans + 1;
        return ans + 1;
    }


    public static void main(String[] args) {
        int[] nums = {3, 4, 3, 4, 3, 4, 3, 4};
        long count = numberOfSubsequences2(nums);
        System.out.println("count = " + count);
    }
}
