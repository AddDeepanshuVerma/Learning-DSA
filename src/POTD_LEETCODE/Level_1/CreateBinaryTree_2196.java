package POTD_LEETCODE.Level_1;

import java.util.HashMap;
import java.util.Map;

class CreateBinaryTree_2196 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    public static void main(String[] args) {
        int[][] arr = {
                {20,15,1},
                {20,17,0},
                {50,20,1},
                {50,80,0},
                {80,19,1}
        };
        System.out.println(createBinaryTree(arr));
    }

    public static TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer, TreeNode> ValToTree = new HashMap<>();
        HashMap<TreeNode, TreeNode> child_parent = new HashMap<>();
        for (int[] arr : descriptions) {
            int parent = arr[0];
            int child = arr[1];
            int side = arr[2];
            TreeNode Parent = ValToTree.getOrDefault(parent, new TreeNode(parent));
            TreeNode Child = ValToTree.getOrDefault(child, new TreeNode(child));
            ValToTree.put(parent, Parent);
            ValToTree.put(child, Child);
            if (side == 1) Parent.left = Child;
            else Parent.right = Child;

            // keep track of children
            child_parent.put(Child, Parent);
        }
        TreeNode parent = child_parent.values().iterator().next();
        while (child_parent.containsKey(parent)) {
            parent = child_parent.get(parent);
        }
        return parent;
    }

    public static TreeNode createBinaryTree2(int[][] descriptions) {
        Map<TreeNode, TreeNode> childToParent = new HashMap<>();
        Map<Integer, TreeNode> valToNode = new HashMap<>();

        for (int[] d : descriptions) {
            final int p = d[0];
            final int c = d[1];
            final int isLeft = d[2];
            TreeNode parent = valToNode.getOrDefault(p, new TreeNode(p));
            TreeNode child = valToNode.getOrDefault(c, new TreeNode(c));
            valToNode.put(p, parent);
            valToNode.put(c, child);
            childToParent.put(child, parent);
            if (isLeft == 1)
                parent.left = child;
            else
                parent.right = child;
        }
        for (Map.Entry<Integer, TreeNode> singal : valToNode.entrySet())
            System.out.println(singal);
            // Pick a random node and traverse upwardly.
        TreeNode root = childToParent.keySet().iterator().next();
        while (childToParent.containsKey(root))
            root = childToParent.get(root);
        return root;
    }
}