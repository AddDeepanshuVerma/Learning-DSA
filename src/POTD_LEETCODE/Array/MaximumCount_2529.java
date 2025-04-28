package POTD_LEETCODE.Array;

class MaximumCount_2529 {
    public int maximumCount(int[] nums) {
        int nCount = 0, pCount = 0;
        for (int num : nums) {
            if (num < 0) nCount++;
            else if (num > 0) pCount++;
        }
        return Math.max(nCount, pCount);
    }

    public static void main(String[] args) {
        int[] nums = {5, 20, 66, 1314};
        int ans = new MaximumCount_2529().maximumCount2(nums);
        System.out.println(ans);
    }

    public int maximumCount2(int[] nums) {
        // as we know array is already sorted
        int start = findStart(nums); // find first index which value is < 0
        int end = findEnd(nums); // find first index which value is > 0

        int n = nums.length;
        return Math.max(start + 1, n - end);
    }

    private int findStart(int[] nums) {
        //find first index which value is < 0
        int start = 0;
        int end = nums.length - 1;
        int ans = -1;

        while (start <= end) {
            int mid = (start + end) >> 1;
            if (nums[mid] < 0) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }

    private int findEnd(int[] nums) {
        //find first index which value is > 0
        int n = nums.length;
        int start = 0;
        int end = n - 1;
        int ans = n;

        while (start <= end) {
            int mid = (start + end) >> 1;
            if (nums[mid] > 0) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }

}