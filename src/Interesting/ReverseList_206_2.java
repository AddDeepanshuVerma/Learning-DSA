package Interesting;

import jdk.jfr.Description;

import java.util.Stack;

class ReverseList_206_2 {
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

    public ListNode reverseList1(ListNode head) {
        ListNode temp = head;
        Stack<Integer> stack = new Stack<>();
        while (temp != null) {
            stack.add(temp.val);
            temp = temp.next;
        }

        temp = head;
        while (temp != null) {
            temp.val = stack.pop();
            temp = temp.next;
        }
        return head;
    }

    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode prev = null, curr = head, next = head.next;
        for (; curr != null; ) {
            curr.next = prev;
            prev = curr;
            curr = next;
            if (next != null) {
                next = curr.next;
            }
        }
        return prev;
    }

    @Description("✨✨✨")
    public ListNode reverseList3(ListNode head) {
        if (head.next == null) return head;

        ListNode newHead = reverseList3(head.next);
        ListNode front = head.next;
        front.next = head;
        head.next = null;
        return newHead;
    }
}