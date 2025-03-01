package _21_Graphs.Leetcode;

import jdk.jfr.Description;

class _6EquationsPossible_990_3 {
    int[] parent;

    int find(int i) {
        if (i != parent[i]) {
            return parent[i] = find(parent[i]);
        }
        return parent[i];
    }

    @Description("inspired from lee codes")
    public boolean equationsPossible(String[] equations) {
        parent = new int[26];
        for (int i = 0; i < 26; i++)
            parent[i] = i;

        for (String s : equations)
            if (s.charAt(1) == '=') {
                parent[find(s.charAt(0) - 'a')] = find(s.charAt(3) - 'a');
            }

        for (String s : equations) {
            if (s.charAt(1) == '!' && find(s.charAt(0) - 'a') == find(s.charAt(3) - 'a')) {
                return false;
            }
        }
        return true;
    }
}