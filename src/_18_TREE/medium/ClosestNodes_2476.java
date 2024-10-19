package _18_TREE.medium;

import java.util.ArrayList;
import java.util.List;

class ClosestNodes_2476 {
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        ArrayList<List<Integer>> ans = new ArrayList<>(); // answer[i] = [mini, maxi]:

        for (int val : queries) {
            //smaller than or equal to val
            int min = findMin(root, val);
            if (min == val) {
                ans.add(List.of(val, val));
                continue;
            }

            //greater than or equal to val
            int max = findMax(root, val);
            ans.add(List.of(min, max));
        }
        return ans;
    }

    //smaller than or equal to val
    private int findMin(TreeNode root, int val) {
        int ans = -1;
        if (root == null) return ans;

        while (root != null) {
            if (root.val == val) {
                ans = root.val;
                break;
            } else if (root.val < val) {
                ans = root.val;
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return ans;
    }

    //greater than or equal to val
    private int findMax(TreeNode root, int val) {
        int ans = -1;
        if (root == null) return ans;

        while (root != null) {
            if (root.val == val) {
                ans = root.val;
                break;
            } else if (root.val < val) {
                root = root.right;
            } else {
                ans = root.val;
                root = root.left;
            }
        }
        return ans;
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