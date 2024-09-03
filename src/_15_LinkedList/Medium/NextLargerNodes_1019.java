package _15_LinkedList.Medium;

import jdk.jfr.Description;

import java.util.*;

class NextLargerNodes_1019 {
    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }
    }

    @Description("Wrong logic, doesn't work")
    public int[] nextLargerNodes(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        int length = 0;
        for (ListNode temp = head; temp != null; temp = temp.next) {
            length++;
            stack.add(temp.val);
        }
        int[] arr = new int[length];
        int max = Integer.MIN_VALUE;
        for (int i = length - 1; i >= 0; i--) {
            int temp = stack.pop();
            arr[i] = max <= temp ? 0 : max;
            max = Math.max(max, temp);
        }
        return arr;
    }

    @Description("Less optimized")
    public int[] nextLargerNodes2(ListNode head) {
//        1. reverse the list
        head = reverse(head);
        Stack<Integer> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        for (ListNode temp = head; temp != null; temp = temp.next) {
            while (!stack.isEmpty() && stack.peek() <= temp.val) {
                stack.pop();
            }
            list.add(stack.isEmpty() ? 0 : stack.peek());
            stack.push(temp.val);
        }
        Collections.reverse(list);
        return list.stream().mapToInt(n -> n).toArray();
    }

    @Description("Optimized sol")
    public int[] nextLargerNodes3(ListNode head) {
//        1. reverse the list
        int length = 0;
        for (ListNode temp = head; temp != null; temp = temp.next) length++;

        head = reverse(head);
        Stack<Integer> stack = new Stack<>();
        int[] arr = new int[length--];

        for (ListNode temp = head; temp != null; temp = temp.next) {
            while (!stack.isEmpty() && stack.peek() <= temp.val) {
                stack.pop();
            }
            arr[length--] = stack.isEmpty() ? 0 : stack.peek();
            stack.push(temp.val);
        }
        System.out.println("list = " + Arrays.toString(arr));
        return arr;
    }

    private ListNode reverse(ListNode head) {
        if (head.next == null) return head;

        ListNode newHead = reverse(head.next);
        head.next.next = head.next;
        head.next = null;
        return newHead;
    }

    private ListNode reverse2(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode newHead = reverse2(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}