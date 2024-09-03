package _15_LinkedList.Medium;

class ReorderList_143 {
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

    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return;

        int length = 0;
        for (ListNode temp = head; temp != null; temp = temp.next) {
            length++;
        }

        for (int i = 2; i < length; i++) {
            head = reverseBetween(head, i, length);
        }
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null || left == right) return head;

        ListNode dHead = new ListNode(-1000, head);
        ListNode prev = dHead;
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }
        ListNode tail = prev.next;

        for (int i = 1; i <= right - left; i++) {
            ListNode temp = prev.next;
            prev.next = tail.next;
            tail.next = tail.next.next;
            prev.next.next = temp;
        }
        return dHead.next;
    }
}