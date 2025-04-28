package POTD_LEETCODE.Two_Pointer;

import jdk.jfr.Description;

@Description("Was done using two pointer approach")
class Solution_2337_2 {
    public static void main(String[] args) {
        System.out.println(canChange("_L", "LL"));
    }

    public static boolean canChange(String start, String target) {
        int n = start.length(), m = target.length(); // both lengths are given equal to each-other
        int i = 0, j = 0;

        while (i < n || j < m) {
            while (i < n && start.charAt(i) == '_') i++;
            while (j < m && target.charAt(j) == '_') j++;

            if (i >= n || j >= n) return i >= n && j >= n;

            if (start.charAt(i) != target.charAt(j)) return false;
            // so both are not equal
            if (start.charAt(i) == 'L' && i < j) return false; // as L can not move right side
            if (start.charAt(i) == 'R' && i > j) return false; // as R can not move Left side
            i++;
            j++;
        }
        return true;
    }

}