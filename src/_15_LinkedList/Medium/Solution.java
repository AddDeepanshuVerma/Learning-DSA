package _15_LinkedList.Medium;


import java.util.concurrent.ThreadLocalRandom;

class Solution {
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


    int length;
    ListNode head;

    public Solution(ListNode head) {
        int length = 0;
        for (ListNode temp = head; temp != null; temp = temp.next) length++;
        this.head = head;
        this.length = length;
    }

    public int getRandom() {
        if (head.next == null) return head.val;

        int rand = ThreadLocalRandom.current().nextInt(0, length);
        ListNode temp = head;
        while (rand-- > 0) temp = temp.next;
        return temp.val;
    }
}