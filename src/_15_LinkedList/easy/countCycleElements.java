package _15_LinkedList.easy;


public class countCycleElements {

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public int hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                int count = 0;
                do {
                    slow = slow.next;
                    count++;
                } while (slow != fast);
                System.out.println("count = " + count);
                return count;
            }
        }
        return -1;
    }
}