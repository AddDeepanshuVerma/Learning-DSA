package _15_LinkedList.Medium;

class DeleteDuplicates_82 {

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


    public ListNode deleteDuplicates(ListNode head) {
        ListNode newHead = new ListNode(-1, head);
        ListNode prev = newHead;
        while (head != null) {
            while (head.next != null && head.val == head.next.val) {
                head = head.next;
            }
            if (prev.next == head) prev = prev.next;
            else prev.next = head.next;
            head = head.next;
        }
        return newHead.next;
    }
}