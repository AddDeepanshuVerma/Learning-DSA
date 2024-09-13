package _10_Recursion.algo2;

class KthGrammar_779 {
    public int kthGrammar(int n, int k) {
        return findElement(n, k);
    }

    private int findElement(int n, int k) {
        if (n == 1 && k == 1) return 0;

        int mid = (int) Math.pow(2, n - 2);

        return k <= mid ? findElement(n - 1, k) : findElement(n - 1, k - mid) ^ 1;
    }
}