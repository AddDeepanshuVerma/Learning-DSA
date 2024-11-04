package DailyCodeChallenge.Greedy;

import java.util.Arrays;

class LongestSquareStreak_2501 {
    public static void main(String[] args) {
        LongestSquareStreak_2501 obj = new LongestSquareStreak_2501();
        int[] nums = {4, 3, 6, 16, 8, 2};
        System.out.println(obj.longestSquareStreak(nums));
    }

    public int longestSquareStreak(int[] nums) {
        Arrays.sort(nums);
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int count = search(nums[i], nums);
            max = Math.max(max, count);
        }
        return max == 0 ? -1 : max + 1;
    }

    private int search(int num, int[] nums) {
        int count = 0;
        int n = num;
        while (true) {
            long temp = n;
            if (temp * temp > Integer.MAX_VALUE) break;

            int index = Arrays.binarySearch(nums, n * n);
            if (index < 0) break;
            count++;
            n = n * n;
        }
        return count;
    }


}