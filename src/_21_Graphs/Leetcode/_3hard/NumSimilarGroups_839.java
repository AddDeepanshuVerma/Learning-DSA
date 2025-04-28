package _21_Graphs.Leetcode._3hard;

import jdk.jfr.Description;

import java.util.HashMap;

@Description("Gets TLE as we are change each string to something instead of comparing two strings")
class NumSimilarGroups_839 {
    int[] parent;

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

    public int numSimilarGroups(String[] strs) {
        int nv = strs.length;
        parent = new int[nv];
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < nv; i++) {
            if (map.containsKey(strs[i])) {
                parent[i] = map.get(strs[i]);
            } else {
                parent[i] = i;
                map.put(strs[i], i);
            }
        }

        // n * m * m
        for (int i = 0; i < strs.length; i++) {
            char[] arr = strs[i].toCharArray();
            for (int j = 0; j < arr.length; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    // swap jth element with kth element & check if it exists in hashMap
                    // then union their indexes
                    swap(arr, j, k);
                    String key = String.valueOf(arr);
                    if (map.containsKey(key)) {
                        union(i, map.get(key));
                    }
                    // backTrack the changes
                    swap(arr, j, k);
                }
            }
        }

        // now all those elements are union now we simply need to return number of diff components
        int count = 0;
        for (int i = 0; i < parent.length; i++) {
            if (i == find(i)) {
                count++;
            }
        }
        return count;
    }

    private void swap(char[] arr, int j, int k) {
        char temp = arr[j];
        arr[j] = arr[k];
        arr[k] = temp;
    }
}