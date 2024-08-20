package _15_LinkedList.easy;

import javax.xml.transform.Result;

class MergeTwoLists_21_2 {
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

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null || list2 == null) {
            return list1 == null ? list2 : list1;
        }
        ListNode res = new ListNode();
        if (list1.val < list2.val) {
            res = new ListNode(list1.val);
            res.next = mergeTwoLists(list1.next, list2);
        } else {
            res = new ListNode(list2.val);
            res.next = mergeTwoLists(list1, list2.next);
        }
        return res;
    }

    public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        ListNode res = new ListNode(-1);
        ListNode temp = res;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                temp.next = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }

        temp.next = list1 == null ? list2 : list1;
        return res.next;
    }
}