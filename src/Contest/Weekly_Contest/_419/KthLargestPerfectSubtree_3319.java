package Contest.Weekly_Contest._419;

import javax.management.MXBean;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class KthLargestPerfectSubtree_3319 {
    PriorityQueue<Integer> pq;

    public int kthLargestPerfectSubtree(TreeNode root, int k) {
        pq = new PriorityQueue<>((a, b) -> b - a);
//        List<Integer> list = new ArrayList<>();
        TreeInfo res = helper(root);
        // find the kth top element from res
        int ans = -1;
        if (pq.size() < k) return ans;

        while (k-- > 1) pq.poll();
        return pq.isEmpty() ? -1 : pq.peek();
    }

    private TreeInfo helper(TreeNode root) {
        if (root == null) return new TreeInfo(0, 0, true);

        TreeInfo left = helper(root.left);
        TreeInfo right = helper(root.right);

        boolean currIsPrftTree = left.isPrftTree & right.isPrftTree;
        int currHeight = Math.max(left.height, right.height) + 1;
        int currCountNodes = left.countNodes + right.countNodes + 1;

        if ((root.left == null && root.right != null) || (root.left != null && root.right == null) || (left.height != right.height)) {
            currIsPrftTree = false;
        }
        if (currIsPrftTree && left.height == right.height) {
            System.out.printf(currCountNodes + " ");
            pq.add(currCountNodes);
        }

        return new TreeInfo(currHeight, currCountNodes, currIsPrftTree);
    }

    static class TreeInfo {
        int height;
        int countNodes;
        boolean isPrftTree;


        public TreeInfo(int height, int countNodes, boolean isPrftTree) {
            this.height = height;
            this.countNodes = countNodes;
            this.isPrftTree = isPrftTree;
        }
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