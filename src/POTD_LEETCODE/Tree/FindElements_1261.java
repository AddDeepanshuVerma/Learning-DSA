package POTD_LEETCODE.Tree;

class FindElements_1261 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-1);
        root.right = new TreeNode(-1);
        var obj = new FindElements_1261(root);
        System.out.println(obj.find(2));

    }

    TreeNode root;

    public FindElements_1261(TreeNode root) {
        this.root = root;
        recoverTree(0, root); // first node value is always 0
    }

    public boolean find(int target) {
        return dfs(target, root);
    }

    private boolean dfs(int target, TreeNode temp) {
        if (temp == null) return false;
        if (temp.val == target) return true;
        if(temp.val > target) return false; // big improvement

        return dfs(target, temp.left) || dfs(target, temp.right);
    }

    private void recoverTree(int val, TreeNode temp) {
        temp.val = val;
        if (temp.left != null) recoverTree((val << 1) + 1, temp.left);
        if (temp.right != null) recoverTree((val << 1) + 2, temp.right);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}