package _10_Recursion.easy;

import jdk.jfr.Description;

class IsPowerOfFour_342 {

    public static void main(String[] args) {
        IsPowerOfFour_342 obj = new IsPowerOfFour_342();
        System.out.println(obj.isPowerOfFour(2147483647));
    }

    public boolean isPowerOfFour(int n) {
        if (n <= 0) return false;
        if (n == 1) return true;
        return n % 4 == 0 && isPowerOfFour(n / 4);
    }

    //    Using log with base equal to the base
    public boolean isPowerOfFour4(int n) {
        if (n <= 0) return false;
        if (n == 1) return true;
        double p = Math.log10(n) / Math.log10(4);
        return p - (int) p == 0;
    }

    //    Generalized method
    public boolean isPowerOfFour2(int n) {
        for (int i = 0; i < 31; i++) {
            if (n == Math.pow(4, i)) return true;
        }
        return false;
    }

    //    Using BIT masking
    public boolean isPowerOfFour5(int n) {
        return n > 0 && (n & (n - 1)) == 0 && (n & 0x55555555) != 0;
        /*
        0x55555555 = 1010101010101010101010101010101
        0x55555555 is to get rid of those power of 2 but not power of 4
        so that the single 1 bit always appears at the odd position
        */
    }

    //    using bit manipulation
    public boolean isPowerOfFour6(int n) {
        return (n & (n - 1)) == 0 && n % 3 == 1;
    }

    //    Generalized method
    public boolean isPowerOfFour3(int n) {
        for (int i = 0; i < 31; i++) {
            double pow = Math.pow(4, i);
            System.out.print("i = " + i + " ");
            System.out.println("pow = " + pow);
            if (n == pow) return true;
            if (n < pow) break;
        }
        return false;
    }

}