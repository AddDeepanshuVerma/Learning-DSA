package _18_TREE.medium;

import java.util.ArrayDeque;

class WidthOfBinaryTree_662 {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        int count = 1;

        // do a level order traversal and each node's id value would be left : (parent * 2 + 1) and right (parent * 2 + 2)
        // at every level we need to calculate last - first id value and store in our ans var with max function

        ArrayDeque<Pair> q = new ArrayDeque<>();
        q.addLast(new Pair(root, 0));

        while (!q.isEmpty()) {
            int size = q.size();
            int min = q.peek().id;
            int max = min;

            for (int i = 0; i < size && !q.isEmpty(); i++) {
                Pair poll = q.removeFirst();
                TreeNode node = poll.node;
                int val = poll.id;
                if (i == size - 1) max = val;

                if (node.left != null) q.addLast(new Pair(node.left, val * 2 + 1));
                if (node.right != null) q.addLast(new Pair(node.right, val * 2 + 2));
            }
            count = Math.max(count, max - min + 1);
        }
        return count;
    }

    record Pair(TreeNode node, int id) {
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