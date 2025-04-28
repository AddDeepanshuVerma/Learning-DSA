package POTD_LEETCODE.BitManipulation;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

class FindDifferentBinaryString_1980_2 {
    public static void main(String[] args) {
        String[] nums = {"111","011","001"};
        System.out.println(findDifferentBinaryString(nums));
    }

    public static String findDifferentBinaryString(String[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (String num : nums) set.add(Integer.parseInt(num, 2));

        int n = nums.length;
        int max = (1 << n) - 1;

        String ans = "";
        for (int num = 0; num <= max; num++) {
            if (!set.contains(num)) {
                ans = Integer.toBinaryString(num);
                break;
            }
        }

        int diff = n - ans.length();
        ans = "0".repeat(diff) + ans;
        return ans;
    }

    public static String findDifferentBinaryString2(String[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (String num : nums) set.add(Integer.parseInt(num, 2));

        int min = 0;
        int len = nums.length;
        int mask = (1 << len) - 1;
        int max = Integer.parseInt(Integer.toBinaryString(mask), 2);

        String ans = "";
        for (int num = min; num <= max; num++) {
            if (!set.contains(num)) {
                ans = Integer.toBinaryString(num);
                break;
            }
        }
        int ansLength = ans.length();
        while (ansLength < len) {
            ans = "0" + ans;
            ansLength++;
        }
        return ans;
    }

}