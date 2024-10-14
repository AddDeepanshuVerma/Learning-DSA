package _18_TREE.algo;

class _30_Flatten_114_2 {

    /*
    Using Morris algorithm
    Similar to flatten a linked list where some nodes has a child node which is again a linked list
    Here : We keep on going right-right and expects there would not be any left, but if we find a left at A,
    we make its left connected to our A's right and A's right to its left now again start at A and
    check further any left are there.

    Here hum ek taraf se soot-te hue chalte hain tree ko and jb bhi left dikhta use wha se tod ke apne aage lga dete hain
    fir us lge hue pe chalte hain.

    */
    public void flatten(TreeNode root) {
        while (root != null) {
            if (root.left == null) {
                root = root.right;
            } else {
                // find the right most element in root's leftBranch
                TreeNode prev = root.left;
                while (prev.right != null) {
                    prev = prev.right;
                }
                prev.right = root.right;
                root.right = root.left;
                root.left = null;
            }
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