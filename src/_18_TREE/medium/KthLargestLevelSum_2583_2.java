package _18_TREE.medium;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.PriorityQueue;

class KthLargestLevelSum_2583_2 {
    public long kthLargestLevelSum(TreeNode root, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        ArrayDeque<TreeNode> q = new ArrayDeque<>();

        q.addLast(root);
        while (!q.isEmpty()) {
            int size = q.size();
            long tempSum = 0;

            for (int i = 0; i < size; i++) {
                TreeNode poll = q.removeFirst();
                tempSum += poll.val;

                if (poll.left != null) q.addLast(poll.left);
                if (poll.right != null) q.addLast(poll.right);
            }
            addInPQ(tempSum, pq, k);
        }
        return pq.size() < k ? -1 : pq.peek();
    }

    private void addInPQ(long tempSum, PriorityQueue<Long> pq, int k) {
        pq.add(tempSum);
        while (pq.size() > k) pq.poll();
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