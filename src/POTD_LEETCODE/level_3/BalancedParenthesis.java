package POTD_LEETCODE.level_3;

public class BalancedParenthesis {
    public static void main(String[] args) {
        int n = 3;
        balancedPara(n);
    }

    private static void balancedPara(int n) {
        int open = 0, close = 0;
        DFS("", open, close, n);
    }

    private static void DFS(String op, int open, int close, int n) {
        if (open > n || close > n) {
            return;
        }
        if (open + close == n * 2) {
            System.out.println("op = " + op);
            return;
        }
        DFS(op + "(", open + 1, close, n);
        if (open > close)
            DFS(op + ")", open, close + 1, n);
    }
}
