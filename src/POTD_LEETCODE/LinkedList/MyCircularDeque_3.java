package POTD_LEETCODE.LinkedList;

class MyCircularDeque_3 {
    int size;
    int n;
    Node front;
    Node last;

    static class Node {
        int val;
        Node prev;
        Node next;

        public Node(int val, Node prev, Node next) {
            this.val = val;
            this.prev = prev;
            this.next = next;
        }

        public Node(int val) {
            this.val = val;
        }
    }

    public MyCircularDeque_3(int k) {
        size = 0;
        n = k;
    }

    public boolean insertFront(int value) {
        if (isFull()) return false;
        if (isEmpty()) {
            front = new Node(value, null, null);
            last = front;
        } else {
            front.prev = new Node(value, null, front);
            front = front.prev;
            if (last == null) last = front;
        }
        size++;
        return true;
    }

    public boolean insertLast(int value) {
        if (isEmpty() || isFull()) return insertFront(value);

        last.next = new Node(value, last, null);
        last = last.next;
        size++;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) return false;
        if (size == 1) {
            last = front = null;
        } else {
            front = front.next;
            front.prev = null;
        }
        size--;
        return true;
    }

    public boolean deleteLast() {
        if (size <= 1) return deleteFront();

        last = last.prev;
        last.next = null;
        size--;
        return true;
    }

    public int getFront() {
        return isEmpty() ? -1 : front.val;
    }

    public int getRear() {
        return isEmpty() ? -1 : last.val;
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