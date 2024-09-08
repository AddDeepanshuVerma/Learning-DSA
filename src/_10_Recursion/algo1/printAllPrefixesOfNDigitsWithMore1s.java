package _10_Recursion.algo1;

public class printAllPrefixesOfNDigitsWithMore1s {
    public static void main(String[] args) {
        int n = 3;
        printParenthesis("", n, 0, 0);
    }

    private static void printParenthesis(String op, int n, int one, int zero) {
        if (n == 0) {
            System.out.printf(op + " ");
            return;
        }
        printParenthesis(op + '1', n - 1, one + 1, zero);
        if (one > zero)
            printParenthesis(op + '0', n - 1, one, zero + 1);
    }

    private static void printPrefixes(String op, String ip) {
        if (!op.isEmpty()) System.out.printf(op + " ");
        if (!ip.isEmpty())
            printPrefixes(op + ip.charAt(0), ip.substring(1));
    }

}
