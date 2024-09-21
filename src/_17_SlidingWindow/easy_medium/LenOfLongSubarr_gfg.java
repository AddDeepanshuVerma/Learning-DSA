package _17_SlidingWindow.easy_medium;

import jdk.jfr.Description;

class LenOfLongSubarr_gfg {
    public static void main(String[] args) {
        int[] arr = {1, 4, 3, 3, 5, 5, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1};
        int n = arr.length;
        System.out.println("n = " + n);
        int k = 16;
        System.out.println(LenOfLongSubarr_gfg.lengthOfLongestSubArray(arr, n, k));
        System.out.println(LenOfLongSubarr_gfg.lengthOfLongestSubArray2(arr, n, k));
    }

    // General format for variable size window
    @Description("This works ONLY on non-negative integers (for negative integers, use HashMap)")
    public static int lengthOfLongestSubArray(int[] arr, int n, int k) {
        int j = 0, i = 0, sum = 0;
//        int ans = Integer.MIN_VALUE;
        int ans = 0;
        while (j < n) {
            sum += arr[j];
            if (sum < k) {
                j++;
            } else if (sum == k) {
                ans = Math.max(ans, j - i + 1);
                j++;
            } else if (sum > k) {
                while (sum > k) {
                    sum -= arr[i];
                    i++;
                }
                // need to check it again as this i,j block might contain our answer OR check sum>k condition before sum == k
                if (sum == k) ans = Math.max(ans, j - i + 1); // ✨✨✨ might have miss this check for arr = {2, 2, 2, 2, 3, 5, 8} k = 9
                j++;
            }
        }
        return ans;
    }

    public static int lengthOfLongestSubArray2(int[] arr, int n, int k) {
        int j = 0, i = 0, sum = 0;
        int length = 0;
        while (j < n) {
            sum += arr[j];
            while (sum > k) sum -= arr[i++];
            if (sum == k) length = Math.max(length, j - i + 1);
            j++;
        }
        return length;
    }

    // Compact way
    private static int lengthOfLongestSubArray3(int[] arr, int n, int k) {
        int i = 0, sum = 0;
//        int ans = Integer.MIN_VALUE;
        int length = 0;
        for (int j = 0; j < n; j++) {
            sum += arr[j];
            while (sum > k) sum -= arr[i++];
            if (sum == k) length = Math.max(length, (j - i + 1));
        }
        return length;
    }

    // more compact
    private static int lengthOfLongestSubArray4(int[] arr, int n, int k) {
        int length = 0;
        for (int j = 0, i = 0, sum = 0; j < n; j++) {
            sum += arr[j];
            while (sum > k) sum -= arr[i++];
            if (sum == k) length = Math.max(length, (j - i + 1));
        }
        return length;
    }
}
