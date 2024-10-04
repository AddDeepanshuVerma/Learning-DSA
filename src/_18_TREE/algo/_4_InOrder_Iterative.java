package _18_TREE.algo;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class _4_InOrder_Iterative {
    static int index;

    static class TreeNode {
        TreeNode left;
        int val;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    // createPreOrderTree
    static TreeNode createTree(int[] arr) {
        index++;
        if (arr[index] == -1) return null;

        TreeNode temp = new TreeNode(arr[index]);
        temp.left = createTree(arr);
        temp.right = createTree(arr);
        return temp;
    }

    static void preOrderTraversal(TreeNode root) {
        if (root == null) /* System.out.print(-1 + " ") */ return;
        System.out.print(root.val + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    static List<Integer> inOrder(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
//        if (root == null) return ans;

        // keep ongoing left and store those nodes to stack
        // if we hit null means, now we need to explore right or stack's top elements 1by1
        // and if top has again left branch again explore left
        // when we have explored all the right branch of stack's stored left root and stack got empty
        // means we are DONE
        // here Inorder : LrR we printed the most left element as it was on top of stack which was a root again
        // now Lr is stored, R is remaining hence take that stored element print it to print Lr and put his right branch on
        // stack to print the last L's right element.
        while (true) {
            if (root != null) {
                stack.addFirst(root);
                root = root.left;
            } else {
                if (stack.isEmpty()) break;
                TreeNode temp = stack.pop();
                ans.add(temp.val);
                root = temp.right;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        index = -1;
        int[] arr = {1, 2, 4, -1, -1, 5, 6, -1, -1, 7, -1, -1, 3, -1, -1};
        TreeNode root = createTree(arr);
//        preOrderTraversal(root);

        System.out.println(inOrder(root));
    }
}
