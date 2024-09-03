package _15_LinkedList.Medium;

import java.util.LinkedList;

class Flatten_430_2 {

    static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }

    public static void main(String[] args) {
        LinkedList<Node> temp = new LinkedList<>();
        temp.clone();
        Node first = temp.getFirst();
    }

    public Node flatten(Node head) {
        Node ans = head;
        tailOfList(head);
        return ans;
    }

    private Node tailOfList(Node head) {
        Node curr = head;
        while (curr != null) {
            if (curr.child != null) {
                Node temp = curr.next;
                curr.next = curr.child;
                curr.child.prev = curr;
                curr.child = null;
                Node tail = curr.next;
                while (tail.next != null) tail = tail.next;
                if (temp != null) temp.prev = tail;
                tail.next = temp;
            }
            curr = curr.next;
        }
        return head;
    }
}