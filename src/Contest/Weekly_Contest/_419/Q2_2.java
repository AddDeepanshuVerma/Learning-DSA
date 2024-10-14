package Contest.Weekly_Contest._419;

import java.util.PriorityQueue;

public class Q2_2 {
    public static void main(String[] args) {

    }

    PriorityQueue<Integer> pq;

    public int kthLargestPerfectSubtree(TreeNode root, int k) {
        pq = new PriorityQueue<>((a, b) -> b - a);
        TreeInfo res = helper(root);
        // find the kth top element from res
        int ans = -1;
        if (pq.size() < k) return ans;

        while (k > 1) {
            pq.poll();
            k--;
        }
        return pq.isEmpty() ? -1 : pq.peek();
    }

    private TreeInfo helper(TreeNode root) {
        if (root == null) return new TreeInfo(0, 0);

        TreeInfo left = helper(root.left);
        TreeInfo right = helper(root.right);

        int newCountNodes = left.countNodes + right.countNodes + 1;
        int newHeight = Math.max(left.height, right.height) + 1;

        if (left.height == right.height) {
            pq.add(newCountNodes);
        }
        return new TreeInfo(newCountNodes, newHeight);
    }

    public static class TreeInfo {
        int countNodes;
        int height;

        public TreeInfo(int countNodes, int height) {
            this.countNodes = countNodes;
            this.height = height;
        }
    }


    public static boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }

    public static int height(TreeNode root) {
        if (root == null) return 0;

        int leftHeight = height(root.left);
        if (leftHeight == -1) return -1;
        int rightHeight = height(root.right);
        if (rightHeight == -1) return -1;

        if (Math.abs(leftHeight - rightHeight) > 0) return -1;

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static int countOfNodes(TreeNode root) {
        if (root == null) return 0;

        int leftBranchCount = countOfNodes(root.left);
        int rightBranchCount = countOfNodes(root.right);

        return leftBranchCount + rightBranchCount + 1;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }


}
