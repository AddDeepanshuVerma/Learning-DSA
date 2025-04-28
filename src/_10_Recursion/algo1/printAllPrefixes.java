package _10_Recursion.algo1;

public class printAllPrefixes {
    public static void main(String[] args) {
        String str = "abcdefgh";
        printPrefixes("", str);

        /*printParenthesis("", str);
        System.out.println();
        printParenthesis2(str);*/
    }

    private static void printPrefixes(String op, String ip) {
        if (!op.isEmpty()) System.out.printf(op + " ");
        if (!ip.isEmpty())
            printPrefixes(op + ip.charAt(0), ip.substring(1));
    }

    private static void printPrefixes3(String op, String ip) {
        System.out.printf(op + " ");
        if (!ip.isEmpty())
            printPrefixes3(op + ip.charAt(0), ip.substring(1));
    }

    private static void printPrefixes2(String str) {
        if (str.isEmpty()) return;
        System.out.printf(str + " ");
        printPrefixes2(str.substring(0, str.length() - 1));
    }
}
