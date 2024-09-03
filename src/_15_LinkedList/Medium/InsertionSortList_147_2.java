package _15_LinkedList.Medium;

class InsertionSortList_147_2 {

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode slow = head, fast = head, temp = null;
        while (fast != null && fast.next != null) {
            temp = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        temp.next = null;
        ListNode firstHead = insertionSortList(head);
        ListNode secondHead = insertionSortList(slow);
        return mergeList(firstHead, secondHead);
    }

    public ListNode mergeList(ListNode firstHead, ListNode secondHead) {
        ListNode temp = new ListNode(0);
        ListNode c1 = firstHead, c2 = secondHead, curr = temp;
        while (c1 != null && c2 != null) {
            if (c1.val < c2.val) {
                curr.next = c1;
                c1 = c1.next;
            } else {
                curr.next = c2;
                c2 = c2.next;
            }
            curr = curr.next;
        }
        curr.next = c1 == null ? c2 : c1;
        return temp.next;
    }
}