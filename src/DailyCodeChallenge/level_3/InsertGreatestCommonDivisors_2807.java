package DailyCodeChallenge.level_3;

class InsertGreatestCommonDivisors_2807 {
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

    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = head;
        ListNode next = head.next;
        while (next != null) {
            prev.next = new ListNode(gcd(prev.val, next.val), next);
            prev = next;
            next = next.next;
        }
        return head;
    }

    public ListNode insertGreatestCommonDivisors2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = head;
        for (ListNode next = head.next; next != null; next = next.next) {
            prev.next = new ListNode(gcd(prev.val, next.val), next);
            prev = next;
        }
        return head;
    }

    public ListNode insertGreatestCommonDivisors3(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode prev = head;
        for (ListNode next = head.next; next != null; prev = next, next = next.next)
            prev.next = new ListNode(gcd(prev.val, next.val), next);
        return head;
    }

    private int gcd(int a, int b) {
        return a == 0 ? b : gcd(b % a, a);
    }


}