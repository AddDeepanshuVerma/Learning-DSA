package POTD_LEETCODE.BitManipulation;

class MinimumSubarrayLength_3097 {
    public static void main(String[] args) {
        MinimumSubarrayLength_3097 obj = new MinimumSubarrayLength_3097();
        int[] nums = {2, 98, 1, 89, 12, 32};
        int k = 92;
        System.out.println(obj.minimumSubarrayLength(nums, k));
    }

    public int minimumSubarrayLength(int[] nums, int k) {
        int i = 0, j = 0, n = nums.length;

        int ans = Integer.MAX_VALUE;
        int[] or = new int[32];
        while (j < n) {
            addElement(or, nums[j]);
            while (isGreater(or, k) && i <= j) {
                ans = Math.min(ans, j - i + 1);
                removeElement(or, nums[i]);
                i++;
            }
            j++;
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private boolean isGreater(int[] arr, int k) {
        int val = 0;
        for (int i = 0; i < 32; i++) {
            if (arr[i] > 0) val |= (1 << i);
            if (val >= k) return true;
        }
        return false;
    }

    private void removeElement(int[] arr, int num) {
        for (int i = 0; i < 32; i++) {
            arr[i] -= ((num >> i) & 1);
        }
    }

    private void addElement(int[] arr, int num) {
        for (int i = 0; i < 32; i++) {
            arr[i] += ((num >> i) & 1);
        }
    }
}