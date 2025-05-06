package POTD_LEETCODE.Array;

import java.util.Arrays;

class BuildArray_1920 {
    // TC : O(n), SC : O(n)
    public static int[] buildArray(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            res[i] = nums[nums[i]];
        }
        return res;
    }

    // TC : O(n), SC : O(1), using 1000 multiplication to keep prev & current element in the same element
    public static int[] buildArray2(int[] nums) {
        /*
         * Max nums's length can be is 1000
         * Hence let's make
         * prev val = 5
         * new  val = 4
         *
         * update it to === new val * 1000 + prev val
         * Hence to keep the new   values use value / 1000
         * And to get the previous value use value % 1000
         * */

        for (int i = 0; i < nums.length; i++) {
            int newVal = nums[nums[i]] % 1000;
            nums[i] = newVal * 1000 + nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] /= 1000;
        }

        return nums;
    }

    //TC : O(n), SC : O(1), compact with same as using 1000 multiplication to keep prev & current element in the same element
    public static int[] buildArray3(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] += (nums[nums[i]] % 1000) * 1000;
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] /= 1000;
        }

        return nums;
    }

    //TC : O(n), SC : O(1), using bit manipulation
    public static int[] buildArray4(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            nums[i] <<= 15;
        }
        /*
         * now our num binary number contains num = from right to left, 15 digits contains zeros while rest contains the prev number
         * hence we will keep new number in starting 15 digit
         * And to retrieve previous number vo right shit previous number by 15 digit
         * */

        // now make each number contain prev && newNumber
        for (int i = 0; i < nums.length; i++) {
            int newNum = nums[nums[i] >> 15] >> 15;
            nums[i] = nums[i] | newNum;
        }

        // now make each number only contain newNumber
        int mask = (1 << 15) - 1; // starting all 15 bits are now one
        for (int i = 0; i < nums.length; i++) {
            nums[i] &= mask;
        }

        return nums;
    }

    //TC : O(n), SC : O(1), compact + using bit manipulation
    public static int[] buildArray5(int[] nums) {
        int n = nums.length;
        int msb = (int) ((Math.log(n) / Math.log(2)) + 1); // to know how many bits to shift

        // to make space for new values to be added
        for (int i = 0; i < n; i++) {
            nums[i] <<= msb;
        }

        // put the new values in created space
        for (int i = 0; i < n; i++) {
            int newNum = nums[nums[i] >> msb] >> msb;
            nums[i] = nums[i] | newNum;
        }

        // creating a mask to help us retrieve new Values
        int mask = (1 << msb) - 1;
        // retrieving new values
        for (int i = 0; i < n; i++) {
            nums[i] &= mask;
        }

        return nums;
    }

    //TC : O(n), SC : O(1), bit manipulation
    public static int[] buildArray6(int[] nums) {
        int n = nums.length;
        int msb = (int) ((Math.log(n) / Math.log(2)) + 1);
        int mask = (1 << msb) - 1;

        // binary String :: new Value....old Value
        for (int i = 0; i < n; i++) {
            nums[i] |= (nums[nums[i]] & mask) << msb;
        }

        for (int i = 0; i < n; i++) {
            nums[i] >>= msb;
        }

        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {5, 0, 1, 2, 3, 4};
        int[] ans = buildArray6(nums);
        System.out.println("ans = " + Arrays.toString(ans));
    }

}
