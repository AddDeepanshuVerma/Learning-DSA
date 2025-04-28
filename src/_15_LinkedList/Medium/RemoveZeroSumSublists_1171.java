package _15_LinkedList.Medium;

import java.util.HashMap;

class RemoveZeroSumSublists_1171 {
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

    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummyHead = new ListNode(0, head);
        HashMap<Integer, ListNode> map = new HashMap<>();
        map.put(0, dummyHead);
        int preSum = 0;

        while (head != null) {
            preSum += head.val;
            if (map.containsKey(preSum)) {
                ListNode start = map.get(preSum);
                ListNode temp = start;
                int pSum = preSum;
                while (temp != head) {
                    temp = temp.next;
                    pSum += temp.val;
                    if (temp != head) map.remove(pSum);
                }
                start.next = temp.next;
            } else map.put(preSum, head);

            head = head.next;
        }
        return dummyHead.next;
    }

    public ListNode removeZeroSumSublists2(ListNode head) {
        ListNode dummyHead = new ListNode(0, head);
        HashMap<Integer, ListNode> map = new HashMap<>();
        map.put(0, dummyHead);
        int preSum = 0;

        while (head != null) {
            preSum += head.val;
            if (map.containsKey(preSum)) {
                ListNode start = map.get(preSum), temp = start.next;
                int pSum = preSum;
                while (temp != head) {
                    pSum += temp.val;
                    map.remove(pSum);
                    temp = temp.next;
                }
                start.next = temp.next;
            } else map.put(preSum, head);

            head = head.next;
        }
        return dummyHead.next;
    }

    public ListNode removeZeroSumSublists3(ListNode head) {
        ListNode dummyHead = new ListNode(0, head);
        HashMap<Integer, ListNode> map = new HashMap<>();
        map.put(0, dummyHead);
        int preSum = 0;

        while (head != null) {
            preSum += head.val;
            if (map.containsKey(preSum)) {
                ListNode start = map.get(preSum), temp = start.next;
                int pSum = preSum;
                for (; temp != head; temp = temp.next) {
                    pSum += temp.val;
                    map.remove(pSum);
                }
                start.next = temp.next;
            } else map.put(preSum, head);

            head = head.next;
        }
        System.gc();
        return dummyHead.next;
    }
}