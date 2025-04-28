package _15_LinkedList.Medium;

class ReverseBetween_92_2 {
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

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head ==  null || head.next == null || left == right) return head;

        ListNode dHead = new ListNode(-1000, head);
        ListNode prev = dHead;
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }
        ListNode curr = prev.next;

        for (int i = 1; i <= right - left; i++) {
            ListNode temp = prev.next;
            prev.next = curr.next;
            curr.next = curr.next.next;
            prev.next.next = temp;
        }
        return dHead.next;
    }
}