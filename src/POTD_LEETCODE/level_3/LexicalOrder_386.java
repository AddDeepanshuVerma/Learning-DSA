package POTD_LEETCODE.level_3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class LexicalOrder_386 {
    public static void main(String[] args) {
        LexicalOrder_386 obj = new LexicalOrder_386();
        System.out.println(obj.lexicalOrder3(100));
    }

    // using tree data structure
    public List<Integer> lexicalOrder3(int max) {
        List<Integer> list = new ArrayList<>();
        for (int num = 1; num <= 9; num++) {
            dfs(num, max, list);
        }
        return list;
    }

    private void dfs(int num, int max, List<Integer> list) {
        if (num > max) return;
        list.add(num);

        for (int j = 0; j <= 9; j++) {
            dfs((num * 10) + j, max, list);
        }
    }

    public List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) list.add(i);

        Comparator<Integer> comp = new Comparator<>() {
            @Override
            public int compare(Integer n1, Integer n2) {
                return String.valueOf(n1).compareTo(String.valueOf(n2));
            }
        };

        Comparator<Integer> comp2 = (n1, n2) -> String.valueOf(n1).compareTo(String.valueOf(n2));
        Comparator<Integer> comp3 = (n1, n2) -> ("" + n1).compareTo("" + n2);

        list.sort(comp);
        return list;
    }

    public List<Integer> lexicalOrder2(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) list.add(i);

        list.sort((a, b) -> String.valueOf(a).compareTo(String.valueOf(b)));
        return list;
    }
}