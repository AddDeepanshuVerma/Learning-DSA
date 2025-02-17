package POTD_LEETCODE.Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

class ReverseOddLevels_2415_bfs {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(3);
        root.right = new TreeNode(5);

        root.left.left = new TreeNode(8);
        root.left.right = new TreeNode(13);

        root.right.left = new TreeNode(21);
        root.right.right = new TreeNode(34);

        TreeNode ans = reverseOddLevels(root);
    }

    public static TreeNode reverseOddLevels(TreeNode root) {
        int level = 0;
//        dfs(root, 0);
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<TreeNode> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                list.add(queue.poll());
            }

            if ((level & 1) == 1) { // means current level is odd level
                int left = 0, right = size - 1;
                while (left < right) {
                    TreeNode treeNode1 = list.get(left++);
                    TreeNode treeNode2 = list.get(right--);
                    int val = treeNode1.val;
                    treeNode1.val = treeNode2.val;
                    treeNode2.val = val;
                }
            }
            // now put left and right child in queue which are not null
            for (TreeNode treeNode : list) {
                TreeNode left = treeNode.left;
                TreeNode right = treeNode.right;
                if (left != null) queue.add(left);
                if (right != null) queue.add(right);
            }
            level++;
        }
        return root;
    }

    private static void dfs(TreeNode root, int level) {
        if (root == null) return;

        if ((level & 1) == 0 && root.left != null && root.right != null) {
            int temp = root.left.val;
            root.left.val = root.right.val;
            root.right.val = temp;
        }
        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }

    private static void print(TreeNode root) {
        if (root == null) return;

        print(root.left);
        System.out.print(root.val + " ");
        print(root.right);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}