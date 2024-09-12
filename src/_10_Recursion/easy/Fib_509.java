package _10_Recursion.easy;

class Fib_509 {
    public int fib(int n) {
        return (n == 0 || n == 1) ?
                n :
                fib(n - 1) + fib(n - 2);
    }

    public int fib2(int n) {
        return n < 2 ?
                n :
                fib2(n - 1) + fib(n - 2);
    }
}
