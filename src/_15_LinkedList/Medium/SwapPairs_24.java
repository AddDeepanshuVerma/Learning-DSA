package _15_LinkedList.Medium;


import jdk.jfr.Description;

class SwapPairs_24 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

    }

    @Description("Wrong solution")
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode temp = head;
        ListNode next = temp.next;
        while (temp.next != null) {
            temp.next = next.next;
            next.next = temp;
            temp = temp.next;
            if (temp != null) {
                next = temp.next;
            }
        }
        return head;
    }

    @Description("Wrong solution")
    public ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head.next;
        ListNode temp = head;
        while (temp != null && temp.next != null) {
            ListNode next = temp.next;
            temp.next = next.next;
            next.next = temp;
            temp = temp.next;
        }
        return dummyHead.next;
    }

    @Description("Perfect solution")
    public ListNode swapPairs3(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummyHead = new ListNode(-1, head);

        ListNode temp = head;
        ListNode prev = dummyHead;
        while (temp != null && temp.next != null) {
            ListNode next = temp.next;
            prev.next = next;
            temp.next = next.next;
            next.next = temp;
            prev = temp;
            temp = temp.next;
        }
        return dummyHead.next;
    }

}