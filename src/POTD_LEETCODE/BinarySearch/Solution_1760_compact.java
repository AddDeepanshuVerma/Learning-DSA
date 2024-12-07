package POTD_LEETCODE.BinarySearch;

class Solution_1760_compact {
    public static int minimumSize(int[] nums, int maxOperations) {
        int start = 1;
        int end = (int) 1E9;
        /*
         int end = 0;
         for (int num : nums) {
             end = Math.max(end, num);
         }
        */
        int ans = -1;
        while (start <= end) {
            int mid = (start + end) >>> 1;
            if (isValid(nums, mid, maxOperations)) {
                ans = mid;
                end = mid - 1;
            } else start = mid + 1;
        }
        return ans;
    }

    private static boolean isValid(int[] arr, int mid, int maxOperations) {
        int count = 0;
        for (int num : arr) {
            count += (num - 1) / mid;
            if (count > maxOperations) return false;
        }
        return count <= maxOperations;
    }
}