package _15_LinkedList.easy;

import jdk.jfr.Description;

import java.util.Stack;

class IsPalindrome_234 {
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

    public boolean isPalindrome(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode temp;
        for (temp = head; temp != null; temp = temp.next) {
            stack.add(temp.val);
        }
        for (temp = head; temp != null; temp = temp.next) {
            if (temp.val != stack.pop()) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome2(ListNode head) {
        if( head == null || head.next == null) return true;
        // find mid element
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //Now slow refers to mid-element
        // hence we revert the array from end to half while half points to null
        ListNode prev = null;
        while (slow != null) {
            ListNode next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }
        // now prev is the head point from end of the original List
        // it will end where the mid was so just compare this to our original head
        while (prev != null) {
            if (prev.val != head.val) {
                return false;
            }
            prev = prev.next;
            head = head.next;
        }
        return true;
    }

    @Description("Wrong understanding hence wrong approach and ans")
    public boolean isPalindrome_(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode temp = head;
        while (slow != null) {
            if (slow.val != temp.val) return false;
            slow = slow.next;
            temp = temp.next;
        }
        return true;
    }
}