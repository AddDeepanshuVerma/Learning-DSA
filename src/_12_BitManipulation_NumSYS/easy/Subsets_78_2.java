package _12_BitManipulation_NumSYS.easy;

class Subsets_78_2 {
    public static void main(String[] args) {
        String str = "abc";
        Subsets_78_2.subsets(str);
    }

    private static void subsets(String str) {
        recursion("", str);
    }

    private static void recursion(String op, String ip) {
        if (ip.isEmpty()) {
            System.out.printf(op +" ");
            return;
        }
        recursion(op, ip.substring(1));
        recursion(op + ip.charAt(0), ip.substring(1));
    }

}