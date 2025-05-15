package POTD_LEETCODE.Dynamic_Programming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class GetLongestSubsequence_2900_Solution {

    List<String> dfs(int i, int prev, String[] words, int[] groups, HashMap<String, List<String>> dp) {
        if (i >= words.length) {
            return new ArrayList<>();
        }

        String key = i + "-" + prev;
        if (dp.containsKey(key)) {
            return dp.get(key);
        }

        // notPick current Index
        List<String> notPick = dfs(i + 1, prev, words, groups, dp);
        // pick this index
        List<String> pick = new ArrayList<>();
        if (prev == -1 || (groups[prev] != groups[i])) {
            pick = new ArrayList<>(dfs(i + 1, i, words, groups, dp));
            pick.add(0, words[i]);
        }

        if (pick.size() > notPick.size()) {
            dp.put(key, pick);
        } else {
            dp.put(key, notPick);
        }

        return dp.get(key);
    }

    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        HashMap<String, List<String>> dp = new HashMap<>();
        return dfs(0, -1, words, groups, dp);
    }

    public static void main(String[] args) {
        var obj = new GetLongestSubsequence_2900_Solution();
        String[] words = {"f", "h", "o", "m", "p", "y", "ce", "xp", "i", "yw", "gp", "r", "a", "x", "j", "ip", "g", "z", "qp", "vt", "s", "lo", "b", "iv", "op",
                "nr", "eu", "k", "eq", "t", "l", "w", "c", "xm", "q", "n"};
        int[] groups = {1, 1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 1, 0, 0, 1, 0, 1};
        List<String> ans = obj.getLongestSubsequence(words, groups);
        System.out.println("ans = " + ans);
    }
}
