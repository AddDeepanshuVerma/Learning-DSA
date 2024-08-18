package _15_LinkedList.Medium;

public class DetectCycle_142 {
    private static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        int length = 0;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                do {
                    length++;
                    slow = slow.next;
                } while (slow != fast);
                break;
            }
        }

        if (length == 0) return null;

        ListNode first = head, second = head;
        while (length-- != 0) second = second.next;

        while (first != second) {
            first = first.next;
            second = second.next;
        }
        return first;
    }
}