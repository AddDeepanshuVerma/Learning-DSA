package _15_LinkedList.Medium;

class Flatten_430 {

    static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }

    public Node flatten(Node head) {
        Node newHead = head;
        while (head != null) {
            if (head.child == null) {
                head = head.next;
                continue;
            }
            // take two node prev and next for where the sublist starts
            Node prev = head;
            Node next = prev.next;

            // join our prev node to that list
            prev.next = prev.child;
            prev.child.prev = prev;
            prev.child = null;

            // go till end of that sub list and join that to our next list
            while (prev.next != null) {
                prev = prev.next;
            }
            prev.next = next;
            if (next != null) {
                next.prev = prev;
            }
            // now loop will again start with head, while now head's child is null
            // hence we are good
        }
        return newHead;
    }
}