package _15_LinkedList.Medium;

import java.util.Arrays;
import java.util.HashMap;

class SplitListToParts_725 {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put(null, "hi");
        map.put(null, "bye");
        System.out.println("map = " + map);
    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

    }

    //    hed = [1,2,3] k = 5
    public ListNode[] splitListToParts(ListNode head, int k) {
        int lenght = 0;
        for (ListNode temp = head; temp != null; temp = temp.next) lenght++;
        ListNode[] arr = new ListNode[k];

        // size of array would be length / k
        int eachElementSize = lenght / k, extraSize = lenght % k;
        ListNode curr = head, prev = null;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = curr;
            for (int j = 1; j <= eachElementSize + (extraSize > 0 ? 1 : 0); j++) {
                prev = curr;
                curr = curr.next;
            }
            if (prev != null) prev.next = null;
            extraSize -= 1;
        }

        return arr;
    }
}