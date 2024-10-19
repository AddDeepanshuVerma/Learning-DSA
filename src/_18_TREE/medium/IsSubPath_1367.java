package _18_TREE.medium;

class IsSubPath_1367 {
    public boolean isSubPath(ListNode list, TreeNode root) {
        if (root == null) return false;

        return check(root, list) || isSubPath(list, root.left) || isSubPath(list, root.right);
    }

    private boolean check(TreeNode root, ListNode list) {
        if (list == null) return true;
        if (root == null) return false;

        return root.val == list.val && (check(root.left, list.next) || check(root.right, list.next));
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

}