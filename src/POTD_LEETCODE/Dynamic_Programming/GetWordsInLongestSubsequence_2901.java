package POTD_LEETCODE.Dynamic_Programming;

import java.util.ArrayList;
import java.util.List;

class GetWordsInLongestSubsequence_2901 {
    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        int i = 0, prev = -1;
        List<String> temp = new ArrayList<>();

        return dfs(i, prev, temp, words, groups, groups.length);
    }

    private List<String> dfs(int i, int prev, List<String> temp, String[] words, int[] groups, int n) {
        if (i == n) {
            return new ArrayList<>(temp);
        }

        List<String> pick = new ArrayList<>();
        if (prev == -1 || (groups[prev] != groups[i] && hammingDistance(words[prev], words[i]))) {
            temp.add(words[i]);
            pick = dfs(i + 1, i, temp, words, groups, n);
            temp.removeLast();
        }
        // not pick
        List<String> notPick = dfs(i + 1, prev, temp, words, groups, n);

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
        var obj = new GetWordsInLongestSubsequence_2901();
        String[] words = {"bab", "dab", "cab"};
        int[] groups = {1, 2, 2};
        List<String> subSeq = obj.getWordsInLongestSubsequence(words, groups);
        System.out.println("subSeq = " + subSeq);
    }

}