package POTD_LEETCODE.Dynamic_Programming;

import java.util.ArrayList;
import java.util.List;

class GetLongestSubsequence_2900_2recursion {

    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        // Let's first calculate the longest subsequence from groups which has alternate diff values

        List<Integer> subSequence = dfs(0, -1, new ArrayList<Integer>(), groups);
        System.out.println("subSequence = " + subSequence);

        List<String> ans = new ArrayList<>();
        for (Integer idx : subSequence) {
            ans.add(words[idx]);
        }
        return ans;
    }

    private List<Integer> dfs(int i, int prev, ArrayList<Integer> list, int[] groups) {
        if (i >= groups.length) {
            return new ArrayList<>(list);
        }

        // notPick current Index
        List<Integer> notPick = dfs(i + 1, prev, list, groups);
        // pick this index
        if (prev == -1 || groups[prev] != groups[i]) {
            list.add(i);
            List<Integer> pick = dfs(i + 1, i, list, groups);
            list.removeLast();
            if (pick.size() > notPick.size()) {
                notPick = pick;
            }
        }

        return notPick;
    }

    public static void main(String[] args) {
        var obj = new GetLongestSubsequence_2900_2recursion();
        String[] words = {"f", "h", "o", "m", "p", "y", "ce", "xp", "i", "yw", "gp", "r", "a", "x", "j", "ip", "g", "z", "qp", "vt", "s", "lo", "b", "iv", "op",
                "nr", "eu", "k", "eq", "t", "l", "w", "c", "xm", "q", "n"};
        int[] groups = {1, 1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 1, 0, 0, 1, 0, 1};
//        String[] words = {"e", "a", "b"};
//        int[] groups = {0, 0, 1};
        List<String> ans = obj.getLongestSubsequence(words, groups);
        System.out.println("ans = " + ans);
    }
}