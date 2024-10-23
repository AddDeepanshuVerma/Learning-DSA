package Contest.Weekly_Contest._420;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Q4 {
    static String[] dp;
    HashMap<Integer, List<Integer>> parentToChild;
    HashMap<Integer, Character> rootToChar;


    public boolean[] findAnswer(int[] parent, String s) {
        int n = parent.length;
        boolean[] ans = new boolean[n];
        parentToChild = new HashMap<>();
        rootToChar = new HashMap<>();

        for (int i = 0; i < n; i++) {
            parentToChild.computeIfAbsent(parent[i], value -> new ArrayList<>()).add(i);
        }

        dp = new String[n];
        // root will always be 0 hence
        String str = dfs(0, s);

        for (int i = 0; i < ans.length; i++) {
            if (isPalindrome(dp[i])) {
                ans[i] = true;
            } /*else {
                ans[i] = false;
            }*/
        }
        return ans;
    }

    private boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }

    private String dfs(int root, String source) {
        if (dp[root] != null) return dp[0];

        List<Integer> children = parentToChild.getOrDefault(root, new ArrayList<>());
        children.sort((a, b) -> b - a);
        StringBuilder ans = new StringBuilder(String.valueOf(source.charAt(root)));

        for (int child : children) {
            ans.append(dfs(child, source));
        }
        return dp[root] = ans.toString();
    }
}
