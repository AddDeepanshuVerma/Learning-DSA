package _15_LinkedList.Medium;


class Solution_2 {
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

    public Solution_2(ListNode head) {
        this.head = head;
        while (head != null) {
            length++;
            head = head.next;
        }
    }

    public int getRandom() {
        if (head.next == null) return head.val;

        int ans = (int)(Math.random() * length);
        System.out.println("ans = " + ans);

        ListNode temp = head;
        while (ans-- > 0) temp = temp.next;
        return temp.val;
    }
}