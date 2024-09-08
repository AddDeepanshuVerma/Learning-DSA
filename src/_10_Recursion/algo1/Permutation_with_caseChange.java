package _10_Recursion.algo1;

public class Permutation_with_caseChange {
    public static void main(String[] args) {
        String str = "3z4";
        caseChange(str);
    }

    private static void caseChange(String ip) {
        String op = "";
        print(op, ip);
    }

    private static void print(String op, String ip) {
        if (ip.isEmpty()) {
            System.out.printf(op +" ");
            return;
        }
        print(op + Character.toLowerCase(ip.charAt(0)), ip.substring(1));
        print(op + Character.toUpperCase(ip.charAt(0)), ip.substring(1));
    }

}

