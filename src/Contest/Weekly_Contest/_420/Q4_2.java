package Contest.Weekly_Contest._420;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Q4_2 {
    HashMap<Integer, List<Integer>> parentToChild;

    public boolean[] findAnswer(int[] parent, String s) {
        int n = parent.length;
        boolean[] ans = new boolean[n];
        parentToChild = new HashMap<>();

        for (int i = 0; i < n; i++) {
            parentToChild.computeIfAbsent(parent[i], value -> new ArrayList<>()).add(i);
        }

        for (int i = 0; i < ans.length; i++) {
            if (isPalindrome(dfs(i, s))) {
                ans[i] = true;
            }
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
        List<Integer> children = parentToChild.getOrDefault(root, new ArrayList<>());
        children.sort((a, b) -> b - a);
        StringBuilder ans = new StringBuilder(String.valueOf(source.charAt(root)));

        for (int child : children) {
            ans.append(dfs(child, source));
        }
        return ans.toString();
    }
}
