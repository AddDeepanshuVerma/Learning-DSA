package _10_Recursion.algo2;

public class Subsets {
    public static void main(String[] args) {
        String str = "abc";
        printSubsets(str, "");
    }

    private static void printSubsets(String ip, String op) {
        if (ip.isEmpty()) {
            System.out.print(op + " ");
            return;
        }
        printSubsets(ip.substring(1), op);
        printSubsets(ip.substring(1), op + ip.charAt(0));
    }
}
