package _18_TREE.easy;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

class InorderTraversal_94_Iterative {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();

        while (true) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                if(stack.isEmpty()) break;
                TreeNode pop = stack.pop();
                ans.add(pop.val);
//                if (pop.right != null) root = pop.right;
                root = pop.right;
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