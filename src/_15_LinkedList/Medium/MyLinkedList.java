package _15_LinkedList.Medium;

class MyLinkedList {
    Node head;
    //    Node tail;
    int size;

    static class Node {
        int val;
        Node next;

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }

        public Node(int val) {
            this.val = val;
        }

        public Node() {
        }
    }

    public MyLinkedList() {
    }

    public void printLL() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    public int get(int index) {
        if (index < 0 || index > size - 1) return -1;

        int count = index;
        Node temp = head;
        while (count > 0) {
            temp = temp.next;
            count--;
        }
        return temp.val;
    }

    public void addAtHead(int val) {
        Node newNode = new Node(val, null);

        newNode.next = head;
        head = newNode;

        size += 1;
    }

    public void addAtTail(int val) {
        if (head == null) {
            addAtHead(val);
            return;
        }
        /*if (size == 0) {
            addAtHead(val);
            return;
        }*/

        Node newNode = new Node(val, null);
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        size += 1;
    }

    //    Add a node of value val before the index-th node in the linked list.
    public void addAtIndex(int index, int val) {
//        If index is greater than the length, the node will not be inserted.
        if (index > size) return;

//        If index equals the length of the linked list, the node will be appended to the end of the linked list.
        if (index == size) {
            addAtTail(val);
            return;
        }

//        When you insert with index < 0, test case will just treat as insert at index = 0.
        if (index <= 0) {
            addAtHead(val);
            return;
        }

        Node newNode = new Node(val, null);

        Node prev = null;
        Node curr = head;

        while (index > 0) {
            prev = curr;
            curr = curr.next;
            index--;
        }
        prev.next = newNode;
        newNode.next = curr;
        size += 1;
    }

    //    Delete the indexth node in the linked list, if the index is valid.
    public void deleteAtIndex(int index) {
        if (index < 0 || index > size - 1) return;
        if (index == 0) {
            head = head.next;
            size -= 1;
            return;
        }

        Node prev = null;
        Node curr = head;
        while (index > 0) {
            prev = curr;
            curr = curr.next;
            index--;
        }
        prev.next = curr.next;
        size -= 1;
    }
}