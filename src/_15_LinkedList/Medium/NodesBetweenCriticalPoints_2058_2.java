package _15_LinkedList.Medium;

import jdk.jfr.Description;

import java.util.ArrayList;
import java.util.List;

@Description("Optimized one")
class NodesBetweenCriticalPoints_2058_2 {
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

    // If there are fewer than two critical points, return [-1, -1].
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        List<Integer> list = new ArrayList<>();
        int index = 1;

        ListNode temp = head.next;
        ListNode prev = head;
        while (temp.next != null) {
            int val = temp.val, pre = prev.val, next = temp.next.val;
            if ((pre < val && next < val) || (val < pre && val < next)) list.add(index);
            temp = temp.next;
            prev = prev.next;
            index++;
        }
        if (list.size() < 2) return new int[]{-1, -1};
        return findDifferences(list);
    }

    private int[] findDifferences(List<Integer> list) {
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < list.size() - 1; i++) {
            minDiff = Math.min(list.get(i + 1) - list.get(i), minDiff);
            if (minDiff == 1) break;
        }
        return new int[]{minDiff, list.getLast() - list.getFirst()};
    }
}