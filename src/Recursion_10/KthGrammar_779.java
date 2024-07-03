package Recursion_10;

class KthGrammar_779 {
    public static void main(String[] args) {
        System.out.println(kthGrammar(5, 15));
    }

    private static int kthGrammar(int n, int k) {
        if (n == 1 && k == 1) return 0;
        int mid = (int) Math.pow(2, n - 2);
        if (k <= mid) return findElement(n - 1, k);
        else return 1 ^ findElement(n - 1, k - mid);
    }

    public static int kthGrammar2(int n, int k) {
        if (k == 0) return 0;
        else return findElement(n, k);
    }
    private static int findElement(int n, int k) {
        if (n == 1 && k == 1) return 0;
        int mid = (int) Math.pow(2, n - 2);
        if (k <= mid) return findElement(n - 1, k);
        else return 1 ^ findElement(n - 1, k - mid);
    }
}