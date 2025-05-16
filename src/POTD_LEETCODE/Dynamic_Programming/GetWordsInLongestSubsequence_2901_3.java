package POTD_LEETCODE.Dynamic_Programming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/*Type of recursion where number of variable inputs were 2 Hence we could apply Memoization : DP
Learn : Try to write such recursion where we could minimize the vary counts in parameter & if one of that is a list,
make sure not to forward it deep in DFS but get it back from DFS function When we get it back,
make sure to hold it through a new ArrayList<> function.*/
class GetWordsInLongestSubsequence_2901_3 {

    private HashMap<String, List<String>> dp;

    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        int i = 0, prev = -1;
        dp = new HashMap<>();
        List<String> subSequence = dfs(i, prev, words, groups, groups.length);
        Collections.reverse(subSequence);
        return subSequence;
    }

    private List<String> dfs(int i, int prev, String[] words, int[] groups, int n) {
        if (i == n) {
            return new ArrayList<>();
        }

        String key = i + "_" + prev;
        if (dp.containsKey(key)) {
            return dp.get(key);
        }

        List<String> pick = new ArrayList<>();
        if (prev == -1 || (groups[prev] != groups[i] && hammingDistance(words[prev], words[i]))) {
            pick = dfs(i + 1, i, words, groups, n);
            pick.add(words[i]);
        }
        // not pick
        List<String> notPick = dfs(i + 1, prev, words, groups, n);

        if (notPick.size() > pick.size()) {
            dp.put(key, notPick);
        } else {
            dp.put(key, pick);
        }

        return dp.get(key);
    }

    private boolean hammingDistance(String a, String b) {
        int diff = 0;
        int m = a.length(), n = b.length();
        if (m != n) return false;

        for (int i = 0; i < m; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                if (++diff > 1) {
                    return false;
                }
            }
        }
        return diff == 1;
    }

    public static void main(String[] args) {
        var obj = new GetWordsInLongestSubsequence_2901_3();
        String[] words = {"bab", "dab", "cab"};
        int[] groups = {1, 2, 2};
        List<String> subSeq = obj.getWordsInLongestSubsequence(words, groups);
        System.out.println("subSeq = " + subSeq);
    }

}