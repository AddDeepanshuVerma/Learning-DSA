package _10_Recursion.algo1;

public class factorial {
    public static void main(String[] args) {
        System.out.println(fac(5));
    }

    private static long fac(int n) {
        return n == 1 ? 1 : n * fac(n - 1);
    }

    private static long fac2(int n) {
        if (n == 1) return 1;
        return n * fac2(n - 1);
    }
}
