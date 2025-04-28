package _10_Recursion.algo2;

public class _Nto1 {
    public static void main(String[] args) {
        print(7);
    }

    private static void print(int n) {
        //base case
        if (n == 1) {
            System.out.println(n);
            return;
        }
        //below 2 lines combined are called signature/induction of function
        System.out.println(n);
        print(n - 1);
    }
}
