package _15_LinkedList.Medium;

class MergeInBetween_1669 {
    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode temp1 = list1, temp2 = list1;
//        find temp1 and temp2
        while (b-- >= 0) {
            temp2 = temp2.next;
            if (a-- > 1) temp1 = temp1.next;
        }
        // put temp1's next to our new list
        temp1.next = list2;
        while (list2.next != null) {
            list2 = list2.next;
        }
        // now our second list's tail will point to the temp2
        list2.next = temp2;
        return list1;
    }
}