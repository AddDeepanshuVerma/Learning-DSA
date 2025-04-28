package _10_Recursion.easy;

import jdk.jfr.Description;

class IsPowerOfThree_326 {
    public boolean isPowerOfThree(int n) {
        if (n <= 0) return false;
        if (n == 1) return true;
        return n % 3 == 0 && isPowerOfThree(n / 3);
    }

    @Description("Generalized method")
    public boolean isPowerOfThree2(int n) {
        for (int i = 0; i < 31; i++) {
            if (n == Math.pow(3, i)) return true;
        }
        return false;
    }

    //    using log functionality
    public boolean isPowerOfThree3(int n) {
        if (n == 0) return false;
        if (n == 1) return true;
        double p = Math.log10(n) / Math.log10(3);
        return p - (int) p == 0;
    }
}