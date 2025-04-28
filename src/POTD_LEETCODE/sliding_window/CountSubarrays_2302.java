package POTD_LEETCODE.sliding_window;

class CountSubarrays_2302 {
    public static long countSubarrays(int[] nums, long k) {
        long sum = 0, count = 0;
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];

            while (sum * (j - i + 1) >= k) {
                sum -= nums[i];
                i++;
            }
            count += j - i + 1;

        }
        return count;
    }


    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
        long k = 5;
        long count = countSubarrays(nums, k);
        System.out.println("count = " + count);
    }
}