package _18_TREE.medium;

class GetDirections_2096_opt2 {
    public static void main(String[] args) {
        GetDirections_2096_opt2 obj = new GetDirections_2096_opt2();
        TreeNode root = new TreeNode(5);

        root.left = new TreeNode(1);
        root.right = new TreeNode(2);

        root.left.left = new TreeNode(3);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(4);

        System.out.println(obj.getDirections(root, 3, 6));

    }

    public String getDirections(TreeNode root, int start, int dest) {
        /*
         * find the least common ancestor of both :  LCA
         * now find path from LCA -> start & LCA to end
         * and in out result just add "U", fist path's length times
         * with appending next path exactly same*/

        TreeNode LCA = findLCA(root, start, dest);
        StringBuilder LCAtoStart = new StringBuilder();
        StringBuilder LCAtoDest = new StringBuilder();

        findPath(LCA, start, LCAtoStart);
        findPath(LCA, dest, LCAtoDest);

        System.out.println("LCA = " + LCA.val);
        System.out.println("LCAtoStart = " + LCAtoStart);
        System.out.println("LCAtoDest = " + LCAtoDest);

        String result = "";
        result = "U".repeat(LCAtoStart.length());
        return result + LCAtoDest;
    }

    private TreeNode findLCA(TreeNode root, int p, int q) {
        if (root == null) return null;
        if (root.val == p || root.val == q) return root;

        TreeNode left = findLCA(root.left, p, q);
        TreeNode right = findLCA(root.right, p, q);

        if (left != null && right != null) return root;
        if (left != null) return left;
        return right;
    }

    private boolean findPath(TreeNode root, int target, StringBuilder path) {
        if (root == null) return false;

        if (root.val == target) return true;

        path.append("L");
        if (findPath(root.left, target, path)) return true;
        path.setLength(path.length() - 1);

        path.append("R");
        if (findPath(root.right, target, path)) return true;
        path.setLength(path.length() - 1);

        return false;
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