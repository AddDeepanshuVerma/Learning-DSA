package _10_Recursion.easy;

import java.util.ArrayList;
import java.util.List;

public class ReverseList_recursion {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(List.of(5, 4, 3, 2, 1));
        System.out.println("list = " + list);
        reverse(list);
        System.out.println("list = " + list);
    }

    private static void reverse(List<Integer> list) {
        if (list.size() == 1) return;
        int removed = list.removeFirst();
        reverse(list);
        list.addLast(removed);
    }
}
