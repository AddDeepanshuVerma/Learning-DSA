package POTD_LEETCODE.Array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution_2554 {
    public static void main(String[] args) {
        int[] banned = {1, 6, 5};
        System.out.println(maxCount2(banned, 5, 6));
    }

    public static int maxCount(int[] banned, int n, int maxSum) {
        Set<Integer> ban = new HashSet<>(Arrays.stream(banned).boxed().toList());
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (ban.contains(i)) continue;
            maxSum -= i;
            if (maxSum >= 0) {
                count++;
            } else break;
        }
        return count;
    }

    public static int maxCount2(int[] banned, int n, int maxSum) {
        Set<Integer> ban = new HashSet<>();
        for (int num : banned) {
            if (num <= n) ban.add(num); // removed extra elements
        }

        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (!ban.contains(i)) {
                maxSum -= i;
                if (maxSum < 0) return count;
                count++;
            }
        }
        return count;
    }

}