package POTD_LEETCODE.Dynamic_Programming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class GetWordsInLongestSubsequence_2901_2 {
    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        int i = 0, prev = -1;
        List<String> subSequence = dfs(i, prev, words, groups, groups.length);
        Collections.reverse(subSequence);
        return subSequence;
    }

    private List<String> dfs(int i, int prev, String[] words, int[] groups, int n) {
        if (i == n) {
            return new ArrayList<>();
        }

        List<String> pick = new ArrayList<>();
        if (prev == -1 || (groups[prev] != groups[i] && hammingDistance(words[prev], words[i]))) {
            pick = new ArrayList<>(dfs(i + 1, i, words, groups, n)); // List is getting returned from HashMap hence create a new one from here, don't reUse it
            pick.add(words[i]);
        }
        // not pick
        List<String> notPick = dfs(i + 1, prev, words, groups, n);

        if (pick.size() > notPick.size()) {
            return pick;
        } else {
            return notPick;
        }
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
        var obj = new GetWordsInLongestSubsequence_2901_2();
        String[] words = {"bab", "dab", "cab"};
        int[] groups = {1, 2, 2};
        List<String> subSeq = obj.getWordsInLongestSubsequence(words, groups);
        System.out.println("subSeq = " + subSeq);
    }

}