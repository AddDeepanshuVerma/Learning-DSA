package _15_LinkedList.easy;

class DeleteNode_237 {
    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public void deleteNode(ListNode node) {
        ListNode head = node.next;
        if (head.val == node.val) {
            head = head.next;
            return;
        }


        ListNode prev = head;
        ListNode curr = head.next;

        while (curr != null) {
            if (curr.val == node.val) {
                prev.next = curr.next;
                break;
            } else {
                prev = curr;
                curr = curr.next;
            }
        }
    }
}