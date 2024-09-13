package DailyCodeChallenge.level_3;

import java.util.HashSet;

class ModifiedList_3217 {
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

    public ListNode modifiedList(int[] nums, ListNode head) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);
        ListNode dummyHead = new ListNode(-1, head);
        ListNode temp = dummyHead;
        while (temp.next != null) {
            if (set.contains(temp.next.val)) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        } return dummyHead.next;
    }
}