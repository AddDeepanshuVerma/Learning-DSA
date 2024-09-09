package _10_Recursion.algo2;

public class PermutationWithCaseChange {
    public static void main(String[] args) {
        String str = "a1b2";
        printWithCaseChange(str);
    }

    private static void printWithCaseChange(String str) {
        String ip = str.toLowerCase();
        String op = "";
        DFS(op, ip);
    }

    private static void DFS(String op, String ip) {
        if (ip.isEmpty()) {
            System.out.println("op = " + op);
            return;
        }
        // Take with capital alpha
        DFS(op + Character.toLowerCase(ip.charAt(0)), ip.substring(1));
        // Take with small alpha
        DFS(op + Character.toUpperCase(ip.charAt(0)), ip.substring(1));

    }
}
