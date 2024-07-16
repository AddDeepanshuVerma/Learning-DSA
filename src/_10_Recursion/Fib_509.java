package _10_Recursion;

class Fib_509 {
    public int fib2(int n) {
        if (n == 0 || n == 1) return n;
        int ans = fib2(n - 1) + fib2(n - 2);
        return ans;
    }

    public int fib3(int n) {
        return n == 0 || n == 1 ? n : fib3(n - 1) + fib3(n - 2);
    }

    public int fib(int n) {
        return n < 2 ? n : fib(n - 1) + fib(n - 2);
    }
}