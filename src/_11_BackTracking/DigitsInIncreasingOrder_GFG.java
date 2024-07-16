package _11_BackTracking;

import java.util.ArrayList;

public class DigitsInIncreasingOrder_GFG {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        int N = 2;
        String op = "";

        digits(N, op, list);
        System.out.println(list);
    }

    private static void digits(int n, String op, ArrayList<Integer> list) {
        if (op.length() == n) {
            list.add(Integer.valueOf(op));
            return;
        }

        if (op.isEmpty()) {
            for (int i = 0; i <= 9; i++) {
                digits(n, op + i, list);
            }
        } else if (!op.equals("0")) {
            int start = op.charAt(op.length() - 1) - '0';
            for (int i = start + 1; i <= 9; i++) {
                digits(n, op + i, list);
            }
        }
    }

}
