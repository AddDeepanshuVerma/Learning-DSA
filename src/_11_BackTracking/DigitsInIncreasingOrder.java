package _11_BackTracking;

public class DigitsInIncreasingOrder {
    public static void main(String[] args) {
        int N = 3;
        // in N == 1, return 0 to n or watch 2nd part : DigitsInIncreasingOrder_2.java
        String op = "";
        digits(N, op);
    }

    private static void digits(int n, String op) {
//        base condition
        if (op.length() == n) {
            System.out.println(op);
            return;
        }
//        if-else used to make a controlled recursion
        if (op.isEmpty()) {
//            choice are multiple so used loop
            for (int i = 1; i <= 9; i++) {
                digits(n, op + i);
            }
        } else {
            int start = op.charAt(op.length() - 1) - '0';
            for (int i = start + 1; i <= 9; i++) {
                digits(n, op + i);
            }
        }
    }

}
