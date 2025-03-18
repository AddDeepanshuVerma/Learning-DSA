package POTD_LEETCODE;

class LongestNiceSubarray_2401 {
    public static int longestNiceSubarray(int[] nums) {
        int prefixOR = 0; // contains or of this window
        int i = 0, j = 0, ans = 1, n = nums.length;
        while (j < n) {
            if ((prefixOR & nums[j]) == 0) {
                // we can include new element only when (all the OR till now) & this element == 0
                // means if this current element is taken & with any of previous element no bits will match to make & operation == 1
                prefixOR |= nums[j];
                ans = Math.max(ans, j - i + 1);
                j++;
            } else {
                while (i < j && (prefixOR & nums[j]) != 0) {
                    // means if we & this new Element with OR of all previous elements then there are few such elements
                    // in the past who has same bit enable as this new number, Hence we need to find and remove till that num
                    prefixOR ^= nums[i];
                    i++;
                }
            }
        }
        return ans;
    }

    public static int longestNiceSubarray2(int[] nums) {
        int prefixOR = 0; // contains or of this window
        int ans = 1;
        int i = 0, j = 0, n = nums.length;
        while (j < n) {
            while (i < j && (prefixOR & nums[j]) != 0) {
                prefixOR ^= nums[i];
                i++;
            }
            prefixOR |= nums[j];
            ans = Math.max(ans, j - i + 1);
            j++;
        }
        return ans;
    }

    public static int longestNiceSubarray3(int[] nums) {
        int prefixOR = 0; // contains or of this window
        int ans = 1;
        int i = 0, n = nums.length;
        for (int j = 0; j < n; j++) {
            while ((prefixOR & nums[j]) != 0) {
                prefixOR ^= nums[i];
                i++;
            }
            prefixOR |= nums[j];
            ans = Math.max(ans, j - i + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {3, 8, 48, 10};
        System.out.println(longestNiceSubarray3(nums));
    }
}