package _10_Recursion.algo2;

public class TOH {
    public static void main(String[] args) {
        int n = 3;
        printTOH(n, "source", "helper", "destination");
    }

    private static void printTOH(int n, String s, String h, String d) {
        if (n == 1) {
            System.out.println(s + " -> " + d);
            return;
        }
        printTOH(n - 1, s, d, h);
        System.out.println(s + " -> " + d);
        printTOH(n - 1, h, s, d);
    }
}
