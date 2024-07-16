package _10_Recursion;

import java.util.ArrayList;

public class JosephusProblem {
    public static void main(String[] args) {
        int n = 5, k = 2;
        System.out.println(lastAlive(n, k));
    }

    private static Integer lastAlive(int n, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) list.add(i);
        int index = 0;
        return JosephusIndex(index, --k, list);
    }

    private static Integer JosephusIndex(int index, int k, ArrayList<Integer> list) {
        if (list.size() == 1) return list.get(0);
        index = (index + k) % list.size();
        list.remove(index);
        return JosephusIndex(index, k, list);
    }
}
