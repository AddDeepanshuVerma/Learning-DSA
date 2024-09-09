package _10_Recursion.algo2;

import java.util.ArrayList;
import java.util.List;

public class _1moreThen0 {
    ArrayList<String> list = new ArrayList<>();

    public static void main(String[] args) {
        int n = 3;
        _1moreThen0 obj = new _1moreThen0();
        obj._1moreThenZero(n);
        System.out.println("List = " + obj.list);
    }

    private void _1moreThenZero(int n) {
        String op = "";
        int one = 0, zero = 0;
        DFS(op, n, one, zero);
    }

    private void DFS(String op, int n, int one, int zero) {
        if (n == 0) {
//            System.out.println("op = " + op);
            list.add(op);
            return;
        }
        DFS(op + "1", n - 1, one + 1, zero);
        if (one > zero) DFS(op + "0", n - 1, one, zero + 1);
    }
}
