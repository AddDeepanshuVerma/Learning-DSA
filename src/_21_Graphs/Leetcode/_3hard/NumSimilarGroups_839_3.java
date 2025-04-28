package _21_Graphs.Leetcode._3hard;

import jdk.jfr.Description;

@Description("Classic DSU with different approach of finding the num of components remaining")
class NumSimilarGroups_839_3 {
    int[] parent;

    public int numSimilarGroups(String[] strs) {
        int nv = strs.length;
        parent = new int[nv];
        for (int i = 0; i < nv; i++) {
            parent[i] = i;
        }

        int totalComponents = nv;
        for (int i = 0; i < strs.length; i++) {
            for (int j = i + 1; j < strs.length; j++) {
                if (isSimilar(strs[i].toCharArray(), strs[j].toCharArray())) {
                    if (find(i) != find(j)) {
                        totalComponents--;
                        union(i, j);
                    }
                }
            }
        }
        return totalComponents;
    }

    int find(int i) {
        if (i == parent[i]) {
            return i;
        }
        return parent[i] = find(parent[i]);
    }

    void union(int a, int b) {
        int bParent = find(b);
        int aParent = find(a);
        if (aParent != bParent) {
            parent[bParent] = aParent;
        }
    }

    private boolean isSimilar(char[] arr1, char[] arr2) {
        int count = 0;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                if (++count > 2) return false;
            }
        }
        return count == 0 || count == 2;
    }

    /*private boolean isSimilar2(char[] arr1, char[] arr2) {
        int firstIndex = -1;
        int secondIndex = -1;
        int count = 0;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                count++;
                if (count > 2) return false; // more than 2 changes needed
                if (firstIndex == -1) {
                    firstIndex = i;
                } else {
                    secondIndex = i;
                }
            }
        }
        if (count == 0) return true;
        return arr1[firstIndex] == arr2[secondIndex] && arr1[secondIndex] == arr2[firstIndex];
    }*/
}