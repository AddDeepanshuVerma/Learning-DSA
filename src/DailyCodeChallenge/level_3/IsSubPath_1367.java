package DailyCodeChallenge.level_3;

class IsSubPath_1367 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isSubPath(ListNode head, TreeNode root) {
//         check if list starts with head
//        return checkThisRoot(head, root);
//        similarly we need to check every level of our root

        if (root == null) return false;
        return checkThisRoot(head, root)
            || isSubPath(head, root.left)
            || isSubPath(head, root.right);
        // any node of above matches with our sequential data then OR operator would not check further
    }

    private boolean checkThisRoot(ListNode head, TreeNode root) {
        if (head == null) return true; // means we have reached till list's last position
        if (root == null) return false; // means we have still not reached till end of list & root got null

        return root.val == head.val // if root val matches with curr list pointer value then we check either of the child does the same or not
                && (checkThisRoot(head.next, root.left) || checkThisRoot(head.next, root.right));
    }
}