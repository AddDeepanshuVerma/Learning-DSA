package _15_LinkedList.easy;

class GetDecimalValue_1290 {
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
        ListNode temp = head;
        int num = 0;
        while(temp != null){
            num = (num * 2) + temp.val;
            temp = temp.next;
        }
        return num;
    }
    public int getDecimalValue3(ListNode head) {
        ListNode temp = head;
        int num = 0;
        while(temp != null){
            num = (num << 1) + temp.val;
            temp = temp.next;
        }
        return num;
    }
}