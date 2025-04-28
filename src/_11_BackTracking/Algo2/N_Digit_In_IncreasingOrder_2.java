package _11_BackTracking.Algo2;

import java.util.stream.IntStream;

public class N_Digit_In_IncreasingOrder_2 {
    public static void main(String[] args) {
        int N = 6;
        dfs("", N);
    }

    private static void dfs(String op, int n) {
        if (n == 0) {
            System.out.println("op = " + op);
            return;
        }
        if (op.isEmpty()) {
            IntStream.range(0, 10).forEach(i -> dfs(op + i, n - 1));
        } else if (!op.equals("0")) {
            int prev = op.charAt(op.length() - 1) - '0';
            IntStream.range(prev + 1, 10).forEach(i -> dfs(op + i, n - 1));
        }
    }
}
