package _18_TREE.medium;

import com.sun.source.tree.Tree;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

class KthLargestLevelSum_2583 {
    public long kthLargestLevelSum(TreeNode root, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>(Comparator.reverseOrder());
//        PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
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
            pq.add(tempSum);
        }
        if (pq.size() < k) return -1;

        while (k-- > 1) pq.poll();

        return !pq.isEmpty() ? pq.peek() : -1;
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