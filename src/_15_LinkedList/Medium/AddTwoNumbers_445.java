package _15_LinkedList.Medium;

class AddTwoNumbers_445 {
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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = revertList(l1);
        l2 = revertList(l2);
        return revertList(addTwoNumbersInOrder(l1, l2));
    }

    private ListNode revertList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = revertList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public ListNode addTwoNumbersInOrder(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(-1), temp = ans;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int v1 = l1 == null ? 0 : l1.val, v2 = l2 == null ? 0 : l2.val, sum = v1 + v2 + carry;
            temp.next = new ListNode(sum % 10);
            temp = temp.next;
            carry = sum / 10;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }
        return ans.next;
    }
}