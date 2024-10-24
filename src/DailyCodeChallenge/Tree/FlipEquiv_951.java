package DailyCodeChallenge.Tree;

class FlipEquiv_951 {
    public static void main(String[] args) {
        FlipEquiv_951 obj = new FlipEquiv_951();
        TreeNode r1 = new TreeNode(6);
        r1.left = new TreeNode(1);
        r1.right = new TreeNode(0);
        TreeNode r2 = new TreeNode(6);
        r2.right = new TreeNode(1);

        System.out.println(obj.flipEquiv(r1, r2));
    }

    public boolean flipEquiv(TreeNode r1, TreeNode r2) {
        if (r1 == null && r2 == null) return true;
        if (r1 == null || r2 == null) return false;
        if (r1.val != r2.val) return false;

        int left1 = r1.left == null ? -1 : r1.left.val;
        int left2 = r2.left == null ? -1 : r2.left.val;

        if (left1 == left2) {
            return flipEquiv(r1.left, r2.left) && flipEquiv(r1.right, r2.right);
        } else {
            return flipEquiv(r1.left, r2.right) && flipEquiv(r1.right, r2.left);
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