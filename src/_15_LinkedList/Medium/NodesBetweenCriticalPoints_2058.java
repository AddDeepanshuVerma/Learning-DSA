package _15_LinkedList.Medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class NodesBetweenCriticalPoints_2058 {
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
        if (head == null || head.next == null || head.next.next == null) {
            return new int[]{-1, -1};
        }

        List<Integer> list = new ArrayList<>();
        int index = 1;

        ListNode temp = head.next;
        ListNode prev = head;
        while (temp.next != null) {
            int val = temp.val;
            int pre = prev.val;
            int next = temp.next.val;
            if ((pre < val && next < val) || (val < pre && val < next)) {
                list.add(index);
            }
            temp = temp.next;
            prev = prev.next;
            index++;
        }
        System.out.println("list = " + list);
        if (list.size() < 2) {
            return new int[]{-1, -1};
        }
        return findDifferences(list);
    }

    private int[] findDifferences(List<Integer> list) {
        int minDiff = Integer.MAX_VALUE;
        int maxDiff = Integer.MIN_VALUE;
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                minDiff = Math.min(Math.abs(list.get(i) - list.get(j)), minDiff);
                maxDiff = Math.max(Math.abs(list.get(i) - list.get(j)), maxDiff);
            }
        }
        return new int[]{minDiff, maxDiff};
    }

    private int[] findDifferences2(List<Integer> list) {
        Collections.sort(list); // no need to sort, array is already sorted
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < list.size() - 1; i++) {
            // No Need to take abs as we know i+1 element is always greater than i hence do (i+1)-i
            minDiff = Math.min(Math.abs(list.get(i) - list.get(i + 1)), minDiff);
        }
        return new int[]{-1, list.getLast() - list.getFirst()};
    }


}