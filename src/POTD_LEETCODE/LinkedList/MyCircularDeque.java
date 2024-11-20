package POTD_LEETCODE.LinkedList;

class MyCircularDeque {
    int[] queue;
    int n;
    int size;
    int front;
    int end;


    public MyCircularDeque(int k) {
        queue = new int[k];
        n = k;
        size = 0;
        front = 0;
        end = 0;
    }

    public boolean insertFront(int value) {
        if (isFull()) return false;
//        get front back by 1 and take modulo and put element
        front = ((front - 1) + n) % n;
        queue[front] = value;
        size++;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) return false;
//        put value at end and now restore end; add 1, take modulo
        queue[end] = value;
        size++;
        end = (end + 1) % n;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) return false;
        // increase front by 1 and decrease size
        front = (front + 1) % n;
        size--;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) return false;
        // decrease end by 1 and decrease size
        end = (end - 1 + n) % n;
        size--;
        return true;
    }

    public int getFront() {
        if (isEmpty()) return -1;
        return queue[front];
    }

    public int getRear() {
        if (isEmpty()) return -1;
//        get end back by 1 and take modulo and put element
        int index = (end - 1 + n) % n;
        return queue[index];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == n;
    }

    public void printQueue() {
        int index = front;
        int size = this.size;
        System.out.print("printing : ");
        for (int i = 0; i < size; i++) {
            System.out.print(queue[index] + " ");
            index = (index + 1) % n;
        }
        System.out.println();
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