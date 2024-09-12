package _11_BackTracking;

public class DigitsInIncreasingOrder_2 {
    public static void main(String[] args) {
        int N = 4;
        String op = "";
        digits(N, op);
    }

    private static void digits(int n, String op) {
        if (op.length() == n) {
            System.out.println(op);
            return;
        }

        if (op.isEmpty()) {
            for (int i = 0; i <= 9; i++) {
                digits(n, op + i);
            }
        } else if (!op.equals("0")) {
            int start = op.charAt(op.length() - 1) - '0';
            for (int i = start + 1; i <= 9; i++) {
                digits(n, op + i);
            }
        }
    }

}
