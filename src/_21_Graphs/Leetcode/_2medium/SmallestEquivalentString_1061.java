package _21_Graphs.Leetcode._2medium;

class SmallestEquivalentString_1061 {
    int[] parent;

    int find(int i) {
        if (i == parent[i]) return i;
        return parent[i] = find(parent[i]);
    }

    void union(int a, int b) {
        int aParent = find(a);
        int bParent = find(b);
        parent[bParent] = aParent;
    }

    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        // DSU preRequisite
        parent = new int[26];
        for (int i = 0; i < parent.length; i++) parent[i] = i;

        int n = s1.length();
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();

        for (int i = 0; i < n; i++) {
            union(arr1[i] - 'a', arr2[i] - 'a');
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
}