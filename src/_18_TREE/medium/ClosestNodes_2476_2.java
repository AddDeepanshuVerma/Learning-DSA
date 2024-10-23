package _18_TREE.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

class ClosestNodes_2476_2 {
    private TreeMap<Integer, Integer> map;

    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        map = new TreeMap<>();
        List<List<Integer>> ans = new ArrayList<>();
        helper(root);

        for (int num : queries) {
            Integer low = map.floorKey(num);
            Integer high = map.ceilingKey(num);

            //if low or high value also not present add -1 else add low or high
            ans.add(List.of((low == null ? -1 : low), (high == null ? -1 : high)));
        }
        return ans;
    }

    void helper(TreeNode root) {
        if (root == null) return;
        map.put(root.val, 0);
        helper(root.left);
        helper(root.right);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

}