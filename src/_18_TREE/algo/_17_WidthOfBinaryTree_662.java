package _18_TREE.algo;

import java.util.ArrayDeque;

class _17_WidthOfBinaryTree_662 {
    public int widthOfBinaryTree(TreeNode root) {
        ArrayDeque<Pair> queue = new ArrayDeque<Pair>();
        int ans = 0;

        queue.addLast(new Pair(root, 0));
        while (!queue.isEmpty()) {

            int size = queue.size();
            int start = queue.peekFirst().id();
            int end = Integer.MIN_VALUE;

            for (int i = 0; i < size; i++) {
                Pair pair = queue.removeFirst();
                TreeNode node = pair.node;
                int currId = pair.id;
                if (i == size - 1) end = currId;

                if (node.left != null) queue.addLast(new Pair(node.left, 2 * currId + 1));
                if (node.right != null) queue.addLast(new Pair(node.right, 2 * currId + 2));
            }
            ans = Math.max(ans, end - start + 1);
        }
        return ans;
    }

    static record Pair(TreeNode node, Integer id) {
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