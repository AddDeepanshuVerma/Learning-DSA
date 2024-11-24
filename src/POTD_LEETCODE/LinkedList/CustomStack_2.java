package POTD_LEETCODE.LinkedList;

class CustomStack_2 {
    private Node start;
    private Node end;
    private int length;
    private final int maxSize;

    static class Node {
        int val;
        Node prev;
        Node next;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node prev, Node next) {
            this.val = val;
            this.prev = prev;
            this.next = next;
        }
    }

    public CustomStack_2(int maxSize) {
        start = null;
        end = null;
        length = 0;
        this.maxSize = maxSize;
    }

    public void push(int val) {
        if (length == maxSize) return;
        end = new Node(val, end, null);
        if (end.prev != null) {
            end.prev.next = end;
        }
        if (start == null) {
            start = end;
        }
        length++;
    }

    public int pop() {
        if (length == 0) return -1;
        int val = end.val;
        if (start == end) {
            start = end = null;
        } else {
            end = end.prev;
            end.next = null;
        }
        length--;
        return val;

    }

    public void increment(int k, int val) {
        k = Math.min(length, k);
        Node temp = start;
        for (int i = 0; i < k; i++) {
            temp.val += val;
            temp = temp.next;
        }
    }
}