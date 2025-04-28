package POTD_LEETCODE.BinarySearch;

class MinCapability_2560_BS {
    public static void main(String[] args) {
        var obj = new MinCapability_2560_BS();
        int[] nums = {2, 7, 9, 3, 1};
        System.out.println(obj.minCapabilityBinarySearch(nums, 2));
    }

    public int minCapabilityBinarySearch(int[] nums, int k) {
        int start = 1, end = (int) 1e9, n = nums.length, ans = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (possible(nums, mid, k)) {
                ans = mid;
                end = mid - 1;
            } else start = mid + 1;
        }
        return ans;
    }

    private boolean possible(int[] nums, int min, int k) {
        int take = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= min) {
                if (++take >= k) return true;
                i++;
            }
        }
        return false;
    }
}
