package POTD_LEETCODE.BitManipulation;

class XorAllNums_2425 {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int ans = 0;
        int n1 = nums1.length, n2 = nums2.length;
        if ((n1 & 1) == 0 && (n2 & 1) == 0) {
            return ans;
        }
        int num1Xor = 0, num2Xor = 0;
        for (int num : nums1) num1Xor ^= num;
        for (int num : nums2) num2Xor ^= num;

        if ((n1 & 1) == 1) {
            ans ^= num2Xor;
        }
        if ((n2 & 1) == 1) {
            ans ^= num1Xor;
        }

        return ans;
    }

    public int xorAllNums2(int[] nums1, int[] nums2) {
        int xor1 = 0, xor2 = 0;
        for (int i : nums1) xor1 ^= i;
        for (int i : nums2) xor2 ^= i;

        return (nums1.length & 1) * xor2 ^ (nums2.length & 1) * xor1;
    }
}