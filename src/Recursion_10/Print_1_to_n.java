package Recursion_10;

public class Print_1_to_n {
    public static void main(String[] args) {
        Print(10); //print 1 to n elements
        System.out.println();
        Print_(10); //print n to 1 elements
    }

    private static void Print(int n) {
        if (n == 1) {
            System.out.print(1);
            return;
        }
        Print(n - 1);
        System.out.print(n);
    }

    private static void Print_(int n) {
        if (n == 1) {
            System.out.print(1);
            return;
        }
        System.out.print(n);
        Print_(n - 1);
    }

}
