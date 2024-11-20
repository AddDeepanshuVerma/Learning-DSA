package POTD_LEETCODE.BitManipulation;

import java.util.Arrays;

class GetMaximumXor_1829 {
    public static void main(String[] args) {
        GetMaximumXor_1829 obj = new GetMaximumXor_1829();
        int[] nums = {0, 1, 1, 3};
        int[] res = obj.getMaximumXor(nums, 2);
        System.out.println("res = " + Arrays.toString(res));
    }

    public int[] getMaximumXor(int[] nums, int maximumBit) {
        // for each values in nums : xor elements 1 by 1 and
        // call the function to find k value to maximize result here k = [0 , 2^maxBit)

        int xor = 0;
        int n = nums.length;
        int[] ans = new int[n];
        for (int i = 0; i < nums.length; i++) {
            xor = xor ^ nums[i];
            ans[n - i - 1] = findMaximum(xor, maximumBit);
        }
        return ans;
    }

    private int findMaximum(int num, int bitLength) {
        int res = 0;
        for (int i = 0; i < bitLength; i++) {
            if (((num >> i) & 1) == 0) {
                res = res | (1 << i);
            }
        }
        return res;
    }

}