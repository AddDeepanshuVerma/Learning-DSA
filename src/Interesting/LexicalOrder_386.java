package Interesting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class LexicalOrder_386 {
    public static void main(String[] args) {
        LexicalOrder_386 obj = new LexicalOrder_386();
        System.out.println(obj.lexicalOrder3(22));
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

}