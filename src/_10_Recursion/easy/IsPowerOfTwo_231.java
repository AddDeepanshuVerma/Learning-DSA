package _10_Recursion.easy;

import jdk.jfr.Description;

class IsPowerOfTwo_231 {
    public boolean isPowerOfTwo(int n) {
        if (n < 1) return false;
        if (n == 1) return true;
        return n % 2 == 0 ?
                isPowerOfTwo(n / 2) :
                false;
    }
    public boolean isPowerOfTwo1(int n) {
        if (n < 1) return false;
        if (n == 1) return true;
        return n % 2 == 0 && isPowerOfTwo1(n / 2);
    }

//    using log functionality
    public boolean isPowerOfTwo2(int n) {
        if (n <= 0) return false;
        if (n == 1) return true;
        double p = Math.log10(n) / Math.log10(2);
        return p - (int) p == 0;
    }

    public boolean isPowerOfTwo3(int n) {
        return n > 0 && (n & (n - 1)) == 0;
//        return (n & (n - 1)) == 0; // also works
    }

    @Description("Generalized method")
    public boolean isPowerOfTwo4(int n) {
        for (int i = 0; i < 31; i++) {
            if (n == Math.pow(2, i)) {
                return true;
            }
        }
        return false;
    }
}