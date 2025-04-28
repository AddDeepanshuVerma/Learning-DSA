package _16_stack_queue.medium;

import com.sun.source.tree.Tree;

import java.util.*;

class LevelOrder_102_DFS {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val) {

            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    List<List<Integer>> res = new ArrayList<>();
//    Below we are printing the whole tree Level wise
    public List<List<Integer>> levelOrder(TreeNode root) {
        level(root, 0);
        return res;
    }

    public void level(TreeNode node, int level) {
        if (node == null) return;
        if (level >= res.size()) {
            List<Integer> l1 = new ArrayList<>();
            l1.add(node.val);
            res.add(l1);
        } else {
            List<Integer> l2 = res.get(level);
            l2.add(node.val);
        }
        level(node.left, level + 1);
        level(node.right, level + 1);
    }

//    Below we are printing the righ view of Tree
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightSide = new ArrayList<>();
        levelWiseRightSide(root, rightSide, 0);
        return rightSide;
    }
//    To print the view of right side we need to search the right side of tree first,
//    hence call right child first
    public void levelWiseRightSide(TreeNode node, List<Integer> rightSide, int level) {
        if (node == null) return;
        if (level == rightSide.size()) rightSide.add(node.val);

        levelWiseRightSide(node.right, rightSide, level + 1);
        levelWiseRightSide(node.left, rightSide, level + 1);
    }
}