package _15_LinkedList.Medium;

class InsertionSortList_147_3 {
    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;

        while (head != null) {
            if (prev.val >= head.val) prev = dummy;

            while (prev.next != null && prev.next.val < head.val) {
                prev = prev.next;
            }
            ListNode tempNext = head.next;
            head.next = prev.next;
            prev.next = head;
            head = tempNext;
        }
        return dummy.next;
    }
}