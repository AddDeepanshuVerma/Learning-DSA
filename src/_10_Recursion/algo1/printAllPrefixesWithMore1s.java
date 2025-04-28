package _10_Recursion.algo1;

public class printAllPrefixesWithMore1s {
    public static void main(String[] args) {
        int n = 39;
        String str = Integer.toBinaryString(n);
        System.out.println("str = " + str);
        printPrefixes("", str);
        System.out.println();
        printParenthesis("", str, 0, 0);
    }

    private static void printParenthesis(String op, String ip, int one, int zero) {
        //Acceptable condition to print
        if (one >= zero && !op.isEmpty()) System.out.printf(op +" ");

        //base condition
        if (ip.isEmpty()) return;

        //Separating based on 1's and 0's
        char c = ip.charAt(0);
        if (c == '1')
            printParenthesis(op + c, ip.substring(1), ++one, zero);
        else
            printParenthesis(op + c, ip.substring(1), one, ++zero);
    }

    private static void printPrefixes(String op, String ip) {
        if (!op.isEmpty()) System.out.printf(op + " ");
        if (!ip.isEmpty())
            printPrefixes(op + ip.charAt(0), ip.substring(1));
    }

}
