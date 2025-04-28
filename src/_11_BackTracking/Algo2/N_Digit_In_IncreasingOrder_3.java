package _11_BackTracking.Algo2;

import jdk.jfr.Description;

import java.util.stream.IntStream;

@Description("fun approach with diff results")
public class N_Digit_In_IncreasingOrder_3 {
    public static void main(String[] args) {
        int N = 3;
        dfs("", N);
    }

    //    Including zero as well ep : 01, 09 are two digits numbers here
    private static void dfs(String op, int n) {
        if (n == 0) System.out.println("op = " + op);
        else IntStream.range(op.isEmpty() ? -1 : op.charAt(op.length() - 1) - '0' + 1, 10).forEach(i -> dfs(op + i, n - 1));
    }
}
