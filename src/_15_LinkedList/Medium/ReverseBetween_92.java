package _15_LinkedList.Medium;

import java.util.Stack;

class ReverseBetween_92 {
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
        if (left == right) return head;
        int length = right - left + 1, start = left;
        ListNode dummyhead = new ListNode(-1, head), prev = dummyhead;
        while (start > 0) {
            prev = prev.next;
            start--;
        }
        Stack<Integer> stack = new Stack<>(); /* put values in stack from pre.val till length */
        ListNode temp = prev;
        int count = length;
        while (count > 0) {
            stack.add(temp.val);
            temp = temp.next;
            count--;
        } /* now pop stack values from and out from prev till length */
        temp = prev;
        count = length;
        while (count > 0) {
            temp.val = stack.pop();
            temp = temp.next;
            count--;
        } /* now return our dummyhead's next */
        return dummyhead.next;
    }
}