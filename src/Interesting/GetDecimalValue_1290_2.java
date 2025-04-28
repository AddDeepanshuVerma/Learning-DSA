package Interesting;

class GetDecimalValue_1290_2 {
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

    public int getDecimalValue(ListNode head) {
        int ans = 0;
        while (head != null) {
            ans <<= 1;
            if (head.val == 1) ans |= 1;
            head = head.next;
        }
        return ans;
    }

    public int getDecimalValue2(ListNode head) {
        int num = 0;
        while (head != null) {
            num = (num * 2) + head.val;
            head = head.next;
        }
        return num;
    }

    public int getDecimalValue3(ListNode head) {
        ListNode temp = head;
        int num = 0;
        while (temp != null) {
            num = (num << 1) + temp.val;
            temp = temp.next;
        }
        return num;
    }

    public int getDecimalValue4(ListNode head) {
        int num = 0;
        for (; head != null; head = head.next)
            num = (num << 1) + head.val;
        return num;
    }
}