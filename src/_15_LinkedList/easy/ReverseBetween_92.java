package _15_LinkedList.easy;

class ReverseBetween_92 {
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

//    public ListNode reverseBetween(ListNode head, int left, int right) {
//        if(head == null || head.next == null) return head;
//        ListNode prev = null, curr = head, next = null;
//
//        int count = 1;
//        while (count < left) {
//            prev = curr;
//            curr = curr.next;
//            count++;
//        }
//        if (curr != null) next = curr.next;
//        int diff = right - left;
//        for (int i = 1; i <= diff; i++) {
//            curr.next = prev;
//
//        }
//
//    }
}