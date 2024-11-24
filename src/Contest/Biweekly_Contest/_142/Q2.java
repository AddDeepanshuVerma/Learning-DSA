package Contest.Biweekly_Contest._142;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Q2 {
    public static void main(String[] args) {
        int[] arr = {};
        Q2 obj = new Q2();
    }

    //    1 <= n <= 10^5
    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;
        int[] newP = new int[n];

        HashMap<Integer, Integer> childToParent = new HashMap<>();

        //parent = [-1,0,0,1,1,1]
        // O(N)
        for (int i = 1; i < n; i++) {
            childToParent.put(i, parent[i]);
        }

        // now from 1 till n-1 find their ancestor

        //newP = [-1,0,0,0,1,1]
        newP[0] = parent[0];

        // O(N) * O(H)
        for (int i = 1; i < n; i++) {
            int anc = findAncestor(i, childToParent, s.toCharArray());  // O(H)
            // for i == 3, we got the new ancestor hence in parent we change index value of i == 3 to ancestor
            newP[i] = anc != -1 ? anc : parent[i];
        }

        // now create a parent to children map
        HashMap<Integer, List<Integer>> parentToChilds = new HashMap<>();

        for (int i = 0; i < newP.length; i++) {
            parentToChilds.computeIfAbsent(newP[i], val -> new ArrayList<>()).add(i);
        }

        int[] ans = new int[n];
        dfs(0, ans, parentToChilds);
        return ans;
    }

    private int dfs(int root, int[] ans, HashMap<Integer, List<Integer>> parentToChilds) {
        int count = 1;
        for (int child : parentToChilds.getOrDefault(root, new ArrayList<>())) {
            count += dfs(child, ans, parentToChilds);
        }
        return ans[root] = count;
    }

    private int findAncestor(int node, HashMap<Integer, Integer> childToParent, char[] arr) {
        int child = node;
        int anc = -1;

        while (childToParent.containsKey(node)) {
            int parent = childToParent.get(node);
            if (arr[parent] == arr[child]) {
                return parent;
            } else {
                node = parent;
            }
        }
        return anc;
    }
}
