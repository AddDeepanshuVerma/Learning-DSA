package _10_Recursion.algo2;

public class PermutationWithSpaces {
    public static void main(String[] args) {
        String str = "ABC";
        printWithSpaces(str);
    }

    private static void printWithSpaces(String str) {
        String op = str.charAt(0) + "";
        String ip = str.substring(1);
        DFS(op, ip);
    }

    private static void DFS(String op, String ip) {
        if (ip.isEmpty()) {
            System.out.println("op = " + op);
            return;
        }
        // Path with spaces
        DFS(op + "_" + ip.charAt(0), ip.substring(1));

        // Path without spaces
        DFS(op + ip.charAt(0), ip.substring(1));

    }
}
