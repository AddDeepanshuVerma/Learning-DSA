package POTD_LEETCODE.LinkedList;

class MyCircularDeque_2 {
    Node front, end;
    int size;
    int n;


    static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    public MyCircularDeque_2(int k) {
        n = k;
    }

    public boolean insertFront(int value) {
        if (isFull()) return false;
        front = new Node(value, front);
        if (end == null) end = front;
        size++;
        return true;
    }

    public boolean insertLast(int value) {
        if (isEmpty() || isFull()) return insertFront(value);

        end.next = new Node(value, null);
        end = end.next;
        size++;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) return false;
        front = front.next;
        if (front == null) end = null;
        size--;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) return false;
        Node temp = front;
        Node prev = null;
        while (temp.next != null) {
            prev = temp;
            temp = temp.next;
        }
        if (prev != null) prev.next = null;
        end = prev;
        if (end == null) front = null;
        size--;
        return true;
    }

    public boolean deleteLast2() {
        if (size <= 1) return deleteFront();
        Node temp = front;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
        end = temp;
        size--;
        return true;
    }

    public int getFront() {
        return isEmpty() ? -1 : front.val;
    }

    public int getRear() {
        return isEmpty() ? -1 : end.val;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == n;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */