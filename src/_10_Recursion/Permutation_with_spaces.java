package _10_Recursion;

public class Permutation_with_spaces {
    public static void main(String[] args) {
        String str = "abc";
        spaces(str);
    }

    private static void spaces(String str) {
        String op = String.valueOf(str.charAt(0));
        String ip = str.substring(1);
        print(op, ip);
    }

    private static void print(String op, String ip) {
        if (ip.isEmpty()) {
            System.out.println(op);
            return;
        }
        print(op +" "+ ip.charAt(0), ip.substring(1));
        print(op + ip.charAt(0), ip.substring(1));
    }

}

