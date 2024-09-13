package _11_BackTracking.Algo2;

public class N_Digit_In_IncreasingOrder {
    public static void main(String[] args) {
        int N = 2;
        print_N_Digits_IncreasingOrder(N);
    }

    private static void print_N_Digits_IncreasingOrder(int n) {
        if (n == 1) {
            for (int i = 0; i < 10; i++) {
                System.out.println("i = " + i);
            }
            return;
        }

        String op = "";
        dfs(op, n);
    }

    private static void dfs(String op, int n) {
        if (n == 0) {
            System.out.println("op = " + op);
            return;
        }
        if (op.isEmpty()) {
            for (int i = 1; i < 10; i++) {
                dfs(op + i, n - 1);
            }
        } else {
            int prev = op.charAt(op.length() - 1) - '0';
            for (int i = prev + 1; i < 10; i++) {
                dfs(op + i, n - 1);
            }
        }

    }
}
