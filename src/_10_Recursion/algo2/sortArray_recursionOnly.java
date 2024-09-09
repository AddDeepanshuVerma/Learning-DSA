package _10_Recursion.algo2;

import java.util.ArrayList;
import java.util.List;

public class sortArray_recursionOnly {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(List.of(5, 4, 3, 2, 1, 1, 2, 3, 3, 4, 54, 3, 2, 1, 3, 44, 3, 2, 2, 4, 44));
        sort(list);
        System.out.println("list = " + list);
    }

    private static void sort(List<Integer> list) {
        if (list.size() == 1) return;
        int removed = list.removeLast();
        sort(list);
        insert(list, removed);
    }

    private static void insert(List<Integer> list, int removed) {
        if (list.isEmpty() || list.getLast() <= removed) {
            list.add(removed);
            return;
        }
        int newRemoved = list.removeLast();
        insert(list, removed);
        list.add(newRemoved);
    }
}
