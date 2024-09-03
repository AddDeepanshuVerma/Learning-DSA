package _15_LinkedList.easy;

public class DeleteDuplicates_83 {
    private static class ListNode {
        public int val;
        public ListNode next;

        public ListNode() {
        }

        public ListNode(int value) {
            this.val = value;
        }

        public ListNode(int value, ListNode next) {
            this.val = value;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        Linked_List obj = new Linked_List();
        obj.addFirst(3);
        obj.addFirst(3);
        obj.addFirst(2);
        obj.addFirst(2);
        obj.addFirst(2);
        obj.addFirst(1);
        obj.addFirst(1);
        obj.print();
        obj.deleteDuplicates();
        obj.print();
    }

    public ListNode deleteDuplicates2(ListNode head) {
        if(head == null) return null;
        ListNode temp = head;
        while (temp.next != null) {
            if (temp.val == temp.next.val) {
                temp.next = temp.next.next;
            } else {
//                increment the pointer to next element
                temp = temp.next;
            }
        }
        return head;
    }


    public ListNode deleteDuplicates(ListNode head) {
        ListNode node = head;
        if (node != null) {
            while (node.next != null) {
                if (node.val == node.next.val) {
                    node.next = node.next.next;
                } else {
                    node = node.next;
                }
            }
        }
        return node;
    }
}
