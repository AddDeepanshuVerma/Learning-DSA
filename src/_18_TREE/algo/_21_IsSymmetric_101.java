package _18_TREE.algo;

class _21_IsSymmetric_101 {

    public static boolean isSymmetric(TreeNode root) {
        return sameTree(root.left, root.right);
    }

    private static boolean sameTree(TreeNode left, TreeNode right) {
        if (left == null || right == null) {
            return left == right;
        }

        return left.val == right.val
                && sameTree(left.left, right.right)
                && sameTree(left.right, right.left);
    }


    static int index;

    static TreeNode createTree(int[] arr) {
        index++;
        if (arr[index] == -1) return null;

        TreeNode temp = new TreeNode(arr[index]);
        temp.left = createTree(arr);
        temp.right = createTree(arr);
        return temp;
    }

    static void preOrderTraversal(TreeNode root) {
        if (root == null) {
//            System.out.print(-1 + " ");
            return;
        }
        System.out.print(root.val + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);

    }

    public static void main(String[] args) {
        index = -1;
        int[] arr = {1, 2, 3, -1, -1, 4, -1, -1, 2, 4, -1, -1, 3, -1, -1};
        TreeNode root = createTree(arr);
        preOrderTraversal(root);
        System.out.println();
        if (root != null) System.out.println(isSymmetric(root));
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