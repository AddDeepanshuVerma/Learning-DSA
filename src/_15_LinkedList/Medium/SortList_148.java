package _15_LinkedList.Medium;

class SortList_148 {
    private static class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode mid = getMid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return merge(left, right);
    }

    //head = [4,2,1,3]
    //After get Mid it will return node = [1, 3] & head = [4, 2]
    ListNode getMid(ListNode head) {
        ListNode slow = head, fast = head;
        int length = 0;
        while (fast != null && fast.next != null) {
            length++;
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println("length = " + length);
        // for head, put second half to null
        ListNode temp = head;
        while (length > 1) {
            temp = temp.next;
            length--;
        }
        temp.next = null;
        return slow;
    }

    ListNode getMid2(ListNode head) {
        ListNode midPrev = null;
        while (head != null && head.next != null) {
            midPrev = (midPrev == null) ? head : midPrev.next;
            head = head.next.next;
        }
        ListNode mid = midPrev.next;
        midPrev.next = null;
        return mid;
    }

    ListNode getMid3(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode temp = head;
        while (fast != null && fast.next != null) {
            temp = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        temp.next = null;
        return slow;
    }
//==================================================================

    ListNode merge(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode temp = head;
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
        temp.next = (list1 != null) ? list1 : list2;
        return head.next;
    }

    ListNode merge2(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(-1);
        ListNode temp = head;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                temp.next = new ListNode(list1.val);
                list1 = list1.next;
            } else {
                temp.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            temp = temp.next;
        }
        temp.next = list1 == null ? list2 : list1;
        return head.next;
    }

}