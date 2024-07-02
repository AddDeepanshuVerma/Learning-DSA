package Recursion_10;

public class Print_1_to_n_tbd {
    public static void main(String[] args) {
        Print(10); //print 1 to n elements
    }

    private static String Print(int n) {
        if (n == 1) {
            return "1" ;
        }
        System.out.print(Print(n - 1));
        System.out.print(n);
        return "";
    }


}
