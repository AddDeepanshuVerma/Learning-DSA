package POTD_LEETCODE.Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

class ReplaceValueInTree_2641_2 {
    public TreeNode replaceValueInTree(TreeNode root) {
        /*
         * first find the level order nodes sum and store in a List
         * now this time do a DFS ans and maintain a level variable where checking
         * root's left and right and updating their value as per given condition while both are not null
         * */

        List<Integer> levelSum = BFS(root);
        int level = 0;
        root.val = 0;
        DFS(root, level, levelSum);

        return root;
    }

    private void DFS(TreeNode root, int level, List<Integer> levelSum) {
        if (root == null) return;
        // work with next level nodes
        int left = 0, right = 0;

        if (root.left != null) left = root.left.val;
        if (root.right != null) right = root.right.val;

        int childSum = levelSum.size() > (level + 1) ? levelSum.get(level + 1) : Integer.MIN_VALUE;

        if (root.left != null) root.left.val = childSum > left + right ? childSum - left - right : 0;
        if (root.right != null) root.right.val = childSum > left + right ? childSum - left - right : 0;

        DFS(root.left, level + 1, levelSum);
        DFS(root.right, level + 1, levelSum);
    }


    private List<Integer> BFS(TreeNode root) {
        ArrayList<Integer> levelSum = new ArrayList<>();
        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();

            int tempSum = 0;
            for (int i = 0; i < size && !q.isEmpty(); i++) {
                TreeNode node = q.poll();
                tempSum += node.val;

                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
            levelSum.add(tempSum);
        }
        return levelSum;
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