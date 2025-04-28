package _15_LinkedList.Medium;

class Partition_86 {
    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode() {
        }
    }

    public ListNode partition(ListNode head, int x) {
        ListNode lessDemo = new ListNode(-1);
        ListNode greatDemo = new ListNode(-1);

        ListNode lessTemp = lessDemo;
        ListNode greatTemp = greatDemo;

        while (head != null) {
            if (head.val < x) {
                lessTemp.next = new ListNode(head.val);
                lessTemp = lessTemp.next;
            } else {
                greatTemp.next = new ListNode(head.val);
                greatTemp = greatTemp.next;
            }
            head = head.next;
        }
        lessTemp.next = greatDemo.next;
        return lessDemo.next;
    }
}