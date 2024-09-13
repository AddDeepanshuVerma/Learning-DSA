package _16_stack_queue.medium;

class FrontMiddleBackQueue {
    Node head;
    Node tail;
    int size;

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

        public Node() {
        }
    }

    public FrontMiddleBackQueue() {
    }

    public void pushFront(int val) {
        head = new Node(val, head);
        size++;
        if (tail == null) tail = head;
    }

    public void pushBack(int val) {
        if (size == 0) {
            pushFront(val);
        } else {
            tail.next = new Node(val);
            tail = tail.next;
            size++;
        }
    }

    public int popFront() {
        if (isEmpty()) return -1;
        int temp = head.val;
        if (size == 1) {
            head = null;
            tail = null;
        } else {
            head = head.next;
        }
        size--;
        return temp;
    }

    public int popBack() {
        if (isEmpty()) return -1;
        else if (size == 1) return popFront();
        else {
            tail = head;
            int k = size;
            while (k - 2 > 0) {
                tail = tail.next;
                k--;
            }
            int temp = tail.next.val;
            tail.next = null;
            size--;
            return temp;
        }
    }

    public int popMiddle() {
        if(isEmpty()) return -1;
        else if (size <= 2) {
            return popFront();
        } else {
            Node prev = getMid(head);
            int temp = prev.next.val;
            prev.next = prev.next.next;
            size--;
            return temp;
        }
    }

    public void pushMiddle(int val) {
        if (size <= 1) {
            pushFront(val);
            return;
        }
        Node prev = getMid(head);
        Node next = prev.next;
        prev.next = new Node(val, next);
        size++;
    }

    private boolean isEmpty() {
        return size == 0;
    }

    private Node getMid(Node head) {
        Node dummyHead = new Node(-1, head);
        Node prev = dummyHead;
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        dummyHead.next = null; // need to re-consider
        return prev;
    }
}

/**
 * Your FrontMiddleBackQueue object will be instantiated and called as such:
 * FrontMiddleBackQueue obj = new FrontMiddleBackQueue();
 * obj.pushFront(val);
 * obj.pushMiddle(val);
 * obj.pushBack(val);
 * int param_4 = obj.popFront();
 * int param_5 = obj.popMiddle();
 * int param_6 = obj.popBack();
 */