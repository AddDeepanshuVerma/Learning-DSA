package DailyCodeChallenge.BitManipulation;

import java.util.Arrays;

class GetMaximumXor_1829_2 {
    public static void main(String[] args) {
        GetMaximumXor_1829_2 obj = new GetMaximumXor_1829_2();
        int[] nums = {0, 1, 1, 3};
        int[] res = obj.getMaximumXor(nums, 2);
        System.out.println("res = " + Arrays.toString(res));
    }

    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int xor = 0, n = nums.length;
        int[] ans = new int[n];
        int mask = (1 << maximumBit) - 1;

        for (int i = 0; i < nums.length; i++) {
            xor = xor ^ nums[i];
            ans[n - i - 1] = xor ^ mask;
        }
        return ans;
    }

}