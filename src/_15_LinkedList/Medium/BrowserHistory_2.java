package _15_LinkedList.Medium;

import java.util.Stack;

class BrowserHistory_2 {
    Node head;
    Node curr;

    static class Node {
        String val;
        Node prev;
        Node next;

        public Node(String val) {
            this.val = val;
        }

        public Node(String val, Node prev, Node next) {
            this.val = val;
            this.prev = prev;
            this.next = next;
        }
    }

    public BrowserHistory_2(String homepage) {
        Node node = new Node(homepage, null, null);
        head = node;
        curr = node;
    }

    public void visit(String url) {
        curr.next = new Node(url, curr, null);
        curr = curr.next;
    }

    public String back(int steps) {
        while (steps > 0 && curr.prev != null) {
            curr = curr.prev;
            steps--;
        }
        return curr.val;
    }

    public String forward(int steps) {
        while (steps > 0 && curr.next != null) {
            curr = curr.next;
            steps--;
        }
        return curr.val;
    }
}