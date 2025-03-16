package _21_Graphs.Leetcode._2medium;

class SmallestEquivalentString_1061_2 {
    int[] parent;

    {   // DSU preRequisite
        parent = new int[26];
        for (int i = 0; i < parent.length; i++) parent[i] = i;
    }

    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        // union all those which belong to same component
        for (int i = 0; i < s1.length(); i++) {
            union(s1.charAt(i) - 'a', s2.charAt(i) - 'a');
        }

        StringBuilder ans = new StringBuilder();
        for (char ch : baseStr.toCharArray()) {
            ans.append(getLowest(ch));
        }

        return ans.toString();
    }

    private char getLowest(char ch) {
        for (char i = 'a'; i <= ch; i++) {
            if (find(i - 'a') == find(ch - 'a')) {
                return i;
            }
        }
        return ch;
    }

    int find(int i) {
        if (i == parent[i]) return i;
        return parent[i] = find(parent[i]);
    }

    void union(int a, int b) {
        int aParent = find(a);
        int bParent = find(b);
        parent[bParent] = aParent;
    }
}