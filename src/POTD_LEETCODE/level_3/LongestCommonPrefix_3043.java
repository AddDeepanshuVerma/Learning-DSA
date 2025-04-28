package POTD_LEETCODE.level_3;

import java.util.HashSet;
import java.util.Set;

class LongestCommonPrefix_3043 {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {4, 4, 4};
        System.out.println(LongestCommonPrefix_3043.lengthOfNum(100));
        System.out.println(LongestCommonPrefix_3043.lengthOfNum2(100));
//        System.out.println(LongestCommonPrefix_3043.longestCommonPrefix(arr1, arr2));
    }

    public static int longestCommonPrefix(int[] arr1, int[] arr2) {
        Set<Integer> prefixes = new HashSet<>();

        for (int num : arr1)
            while (num > 0) {
                prefixes.add(num);
                num /= 10;
            }
//        System.out.println("prefixes = " + prefixes);
        int count = 0;
        for (int num : arr2)
            while (num > 0) {
                if (prefixes.contains(num)) {
                    int len = (int) (Math.log10(num) + 1);
                    if (len > count) count = len;
                }
                num /= 10;
            }
        return count;
    }

    private static int lengthOfNum(int num) {
        int count = 0;
        while (num > 0) {
            count++;
            num /= 10;
        }
        return count;
    }

    private static int lengthOfNum2(int num) {
        return (int) (Math.log10(num) + 1);
    }
}