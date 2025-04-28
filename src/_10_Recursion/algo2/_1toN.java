package _10_Recursion.algo2;

import java.sql.SQLOutput;

public class _1toN {
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
        print(n - 1);
        System.out.println(n);
    }

    private static void print2(int n) {
        if (n == 1) {
            System.out.println(n);
        } else {
            print2(n - 1);
            System.out.println(n);
        }
    }
}
