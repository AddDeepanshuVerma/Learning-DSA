package POTD_LEETCODE.BackTracking;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

class FindDifferentBinaryString_1980 {
    public static void main(String[] args) {
        String[] nums = {"111", "011", "001"};
        System.out.println(findDifferentBinaryString(nums));
    }

    public static String findDifferentBinaryString(String[] nums) {
        HashSet<String> set = new HashSet<>();
        Collections.addAll(set, nums);

        StringBuilder curr = new StringBuilder();
        int n = nums[0].length();

        //dfs(n, curr, set);
        solve(n, curr, set);
        return curr.toString();
    }

    private static boolean solve(int n, StringBuilder curr, Set<String> set) {
        if (curr.length() == n) {
            return !set.contains(curr.toString());
        }

        int len = curr.length();
        for (char c = '0'; c < '2'; c++) {
            curr.append(c);
            if (solve(n, curr, set)) return true;
            curr.setLength(len);
        }

        return false;
    }

    private static boolean dfs(int n, StringBuilder curr, Set<String> set) {
        if (curr.length() == n) {
            return !set.contains(curr.toString());
        }

        int len = curr.length();
        curr.append(0);
        if (dfs(n, curr, set)) return true;
        curr.setLength(len);

        curr.append(1);
        if (dfs(n, curr, set)) return true;
        curr.setLength(len);

        return false;
    }
}