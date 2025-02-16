package POTD_LEETCODE.BackTracking;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class ConstructDistancedSequence_1718 {
    static int[] ans;

    public static void main(String[] args) {
        int[] res = constructDistancedSequence(6);
        System.out.println("res = " + Arrays.toString(res));
    }

    public static int[] constructDistancedSequence(int n) {
        ans = new int[(n << 1) - 1];
        Set<Integer> seen = new HashSet<>();
        Arrays.fill(ans, -1);
        dfs(n, seen);
        return ans;
    }

    private static boolean dfs(int n, Set<Integer> seen) {
        if (seen.size() == n) {
            return true;
        }

        for (int num = n; num >= 1; num--) {
            if (!seen.contains(num)) {
                int idx = 0;
                while (idx < ans.length && ans[idx] != -1) idx++;
                if (num != 1) {
                    if (ans[idx] == -1 && (idx + num) < ans.length && ans[idx + num] == -1) {
                        ans[idx] = num;
                        ans[idx + num] = num;
                        seen.add(num);
                        if (dfs(n, seen)) return true;
                        ans[idx] = -1;
                        ans[idx + num] = -1;
                        seen.remove(num);
                    }
                } else {
                    if (ans[idx] == -1) {
                        ans[idx] = num;
                        seen.add(num);
                        if (dfs(n, seen)) return true;
                        ans[idx] = -1;
                        seen.remove(num);
                    }
                }
            }
        }
        return false;
    }
}