package POTD_LEETCODE.Tree;

class RecoverFromPreorder_1028 {
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

    public static void main(String[] args) {
        String traversal = "1-2--3--4-5--6--7";
        TreeNode root = recoverFromPreorder(traversal);
        printTree(root);
    }

    static int i, n;
    static String s;

    public static TreeNode recoverFromPreorder(String traversal) {
        int depth = 0;
        i = 0;
        s = traversal;
        n = s.length();
        return dfs(depth);
    }

    private static TreeNode dfs(int d) {
        if (i >= s.length()) return null;
        // now count dashes & check if we are at expected depth
        int j = i;
        while (j < n && s.charAt(j) == '-') {
            j++;
        }
        int dashes = j - i;
        if (dashes != d) return null;

        // now calculate the integer value
        i += dashes;
        int val = 0;

        while (i < n && s.charAt(i) != '-') {
            val = val * 10 + (s.charAt(i) - '0');
            i++;
        }

        TreeNode temp = new TreeNode(val);
        temp.left = dfs(d + 1);
        temp.right = dfs(d + 1);
        return temp;
    }

    private static void printTree(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        printTree(root.left);
        printTree(root.right);
    }

}