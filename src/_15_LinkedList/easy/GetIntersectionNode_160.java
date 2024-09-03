package _15_LinkedList.easy;

import jdk.jfr.Description;

import java.util.HashSet;

public class GetIntersectionNode_160 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode4(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        ListNode tempA = headA, tempB = headB;
        while (tempA != tempB) {
            tempA = tempA.next;
            tempB = tempB.next;
            if (tempA == tempB) return tempA;
            if (tempA == null) tempA = headB;
            if (tempB == null) tempB = headA;
        }
        return null;
    }

    public ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        int lengthA = 0, lengthB = 0;
        for (ListNode tempA = headA; tempA != null; tempA = tempA.next) {
            lengthA++;
        }
        for (ListNode tempA = headB; tempA != null; tempA = tempA.next) {
            lengthB++;
        }
        if (lengthA < lengthB) {
            return collideBoth(headA, headB, lengthB - lengthA);
        } else {
            return collideBoth(headB, headA, lengthA - lengthB);
        }
    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        HashSet<ListNode> set = new HashSet<>();
        for (ListNode tempA = headA; tempA != null; tempA = tempA.next)
            set.add(tempA);
        for (ListNode tempB = headB; tempB != null; tempB = tempB.next) {
            if (set.contains(tempB)) {
                return tempB;
            }
        }
        return null;
    }

    private ListNode collideBoth(ListNode small, ListNode large, int diff) {
        while (diff > 0) {
            large = large.next;
            diff--;
        }
        while (small != large) {
            small = small.next;
            large = large.next;
        }
        return small;
    }

    @Description("Does not work")
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tempA = headA;
        while (tempA != null) {
            // check tempA.next address to every next nodes address of headB
            for (ListNode tempB = headB; tempB != null; tempB = tempB.next) {
                if (tempA.next == tempB.next) {
                    return tempA.next == null ? tempA : tempA.next;
                }
            }
            tempA = tempA.next;
        }
        return null;
    }
}