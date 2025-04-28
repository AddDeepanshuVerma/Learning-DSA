package _15_LinkedList.Medium;

class SwapNodes_1721 {
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

    public ListNode swapNodes(ListNode head, int k) {
        if (head == null || head.next == null) return head;

        int size = 0;
        for (ListNode temp = head; temp != null; temp = temp.next) {
            size++;
        }

        ListNode dHead = new ListNode(-1, head);

//        now we need to find our first node and its previous one
        ListNode p1 = dHead, prevP1 = dHead;
        for (int i = 1; i < k; i++) {
            prevP1 = prevP1.next;
        }
        p1 = prevP1.next;

//        now need to find second pointer & its previous one
        ListNode p2 = dHead, prevP2 = dHead;
        for (int i = 0; i < size - k; i++) {
            prevP2 = prevP2.next;
        }
        p2 = prevP2.next;

//        now switch pointer to each other
        prevP1.next = p2;
        prevP2.next = p1;
        ListNode dummy = p2.next;
        p2.next = p1.next;
        p1.next = dummy;

        return dHead.next;
    }
}