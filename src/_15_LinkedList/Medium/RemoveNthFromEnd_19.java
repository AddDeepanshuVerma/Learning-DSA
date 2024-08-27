package _15_LinkedList.Medium;

class RemoveNthFromEnd_19 {
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

        public ListNode() {
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 0;
        for (ListNode temp = head; temp != null; temp = temp.next) length++;

        /* As per 0th indexing */
        int index = length - n;
        ListNode dHead = new ListNode(-1, head), temp = dHead;

        for (int i = 0; i < index; i++) temp = temp.next;
        temp.next = temp.next.next;
        return dHead.next;
    }

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dHead = new ListNode(-1, head), slow = dHead, fast = dHead;
        while (fast != null) {
            fast = fast.next;
            if (n < 0) slow = slow.next;
            n--;
        }
        slow.next = slow.next.next;
        return dHead.next;
    }
}