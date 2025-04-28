package _15_LinkedList.Medium;

class RotateRight_61 {
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

    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) return head;

        int length = 0;
        for (ListNode temp = head; temp != null; temp = temp.next) length++;

        if(k % length == 0) return head;

        int diff = length - (k % length);

        ListNode prev = head, tail = head;

        while (tail.next != null) {
            if (diff > 1) {
                prev = prev.next;
                diff--;
            }
            tail = tail.next;
        }
        ListNode newHead = prev.next;
        tail.next = head;
        prev.next = null;
        return newHead;
    }

    public ListNode rotateRight2(ListNode head, int k) {
        if(head == null || head.next == null) return head;

        int length = 1;
        ListNode curr = head;
        // get till the tail of list also find length of array
        while (curr.next != null) {
            curr = curr.next;
            length++;
        }
        if(k % length == 0) return head;
        curr.next = head;

        // now shift our head node till previous node of our new node
        int diff = length - (k % length);
        for (int i = 1; i < diff; i++) {
            head = head.next;
        }
        ListNode newHead = head.next;
        head.next = null;
        return newHead;
    }
}