package _15_LinkedList.easy;

import jdk.jfr.Description;

public class Linked_List {
    private Node head;
    private Node tail;

    private int size;

    public Linked_List() {
        this.size = 0;
    }

    public static class Node {
        private int val;
        private Node next;

        public Node() {
        }

        public Node(int value) {
            this.val = value;
        }

        public Node(int value, Node next) {
            this.val = value;
            this.next = next;
        }
    }

    public void getSize() {
        System.out.println(size);
    }

    public static void main(String[] args) {
        /*Linked_List obj = new Linked_List();
        obj.addFirst(3);
        obj.addFirst(3);
        obj.addFirst(2);
        obj.addFirst(2);
        obj.addFirst(2);
        obj.addFirst(1);
        obj.addFirst(1);
        obj.print();
        obj.deleteDuplicates();
        obj.print();*/

        /*Linked_List obj = new Linked_List();
        obj.addFirst(9);
        obj.addFirst(8);
        obj.addFirst(7);
        obj.print();
        obj.getSize();
        obj.addLast(50);
        obj.addLast(50);
        obj.addLast(50);
        obj.addLast(50);
        obj.print();*/
        Linked_List list1 = new Linked_List();
        list1.addLast(1);
        list1.addLast(2);
        list1.addLast(4);
        list1.addLast(5);
        list1.addLast(5);
        list1.addLast(5);
        list1.print();

        Linked_List list2 = new Linked_List();
        list2.addLast(1);
        list2.addLast(3);
        list2.addLast(4);
        list2.addLast(7);
        list2.addLast(8);
        list2.addLast(9);
        list2.print();

        Linked_List obj = new Linked_List();
        Linked_List ans = obj.mergeTwoLists(list1.head, list2.head);
        ans.print();

    }

    @Description("https://leetcode.com/problems/linked-list-cycle/")
    public boolean hasCycle(Linked_List head) {
        Node slow = head.head, fast = head.head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    @Description("https://leetcode.com/problems/merge-two-sorted-lists/")
    public Linked_List mergeTwoLists(Node list1, Node list2) {
        Linked_List head = new Linked_List();
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                head.addLast(list1.val);
                list1 = list1.next;
            } else {
                head.addLast(list2.val);
                list2 = list2.next;
            }
        }
        while (list1 != null) {
            head.addLast(list1.val);
            list1 = list1.next;
        }
        while (list2 != null) {
            head.addLast(list2.val);
            list2 = list2.next;
        }
        return head;
    }

    @Description("https://leetcode.com/problems/remove-duplicates-from-sorted-list/")
    public void deleteDuplicates() {
        Node node = head;
        if (node != null) {
            while (node.next != null) {
                if (node.val == node.next.val) {
                    node.next = node.next.next;
                } else {
                    node = node.next;
                }
            }
        }
    }

    public void addLast(int val) {
        if (size == 0) {
            addFirst(val);
            return;
        }
        Node node = new Node(val);
        tail.next = node;
        tail = node;
        tail.next = null;
        size += 1;
    }

    public void addFirst(int val) {
        Node node = new Node(val);

        node.next = head;
        head = node;
        size += 1;
        if (tail == null) tail = head;
    }

    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    public void print2() {
        Node temp = head;
        int index = 0;
        while (index < size) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
            index++;
        }
        System.out.println("END");
    }

}
