package POTD_LEETCODE.Dynamic_Programming;

import java.util.ArrayList;
import java.util.List;

class GetLongestSubsequence_2900_1recursion {
    private List<Integer> subSequence;

    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        // Let's first calculate the longest subsequence from groups which has alternate diff values
        subSequence = new ArrayList<>();
        dfs(0, -1, new ArrayList<Integer>(), groups);
        System.out.println("subSequence = " + subSequence);

        List<String> ans = new ArrayList<>();
        for (Integer idx : subSequence) {
            ans.add(words[idx]);
        }

        return ans;
    }

    private void dfs(int i, int prev, ArrayList<Integer> list, int[] groups) {
        if (i >= groups.length) {
            if (list.size() > subSequence.size()) {
                subSequence = new ArrayList<>(list);
            }
            return;
        }

        // notPick current Index
        dfs(i + 1, prev, list, groups);
        // pick this index
        if (prev != groups[i]) {
            list.add(i);
            dfs(i + 1, groups[i], list, groups);
            list.removeLast();
        }
    }

    public static void main(String[] args) {
        var obj = new GetLongestSubsequence_2900_1recursion();
        String[] words = {"a", "b", "c", "d"};
        int[] groups = {1, 0, 1, 1};
        List<String> ans = obj.getLongestSubsequence(words, groups);
        System.out.println("ans = " + ans);
    }
}