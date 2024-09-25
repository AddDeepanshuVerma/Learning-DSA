package _15_LinkedList.Medium;

class InsertionSortList_147_4 {
    static class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode middle = getMiddleNode(head);
        ListNode left = insertionSortList(middle);
        ListNode right = insertionSortList(head);
        return mergeLists2(left, right);
    }

    private ListNode mergeLists2(ListNode left, ListNode right) {
        ListNode dummyHead = new ListNode(-1);
        ListNode temp = dummyHead;
        while (left != null && right != null) {
            if (left.val < right.val) {
                temp.next = left;
                left = left.next;
            } else {
                temp.next = right;
                right = right.next;
            }
            temp = temp.next;
        }
        temp.next = left == null ? right : left;
        return dummyHead.next;
    }

    private ListNode mergeLists(ListNode left, ListNode right) {
        if (left == null || right == null) {
            return left == null ? right : left;
        }
        ListNode result = new ListNode();
        if (left.val < right.val) {
            result = left;
            result.next = mergeLists(left.next, right);
        } else {
            result = right;
            result.next = mergeLists(left, right.next);
        }
        return result;
    }

    private ListNode getMiddleNode(ListNode head) {
        ListNode slow = head, fast = head;

        ListNode prev = slow;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if (prev != null) prev.next = null;
        return slow;
    }
}