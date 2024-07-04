package Recursion_10;

class IsPowerOfTwo_231 {
    public boolean isPowerOfTwo(int n) {
        if (n == 0) return false;
        if (n == 1) return true;
        return n % 2 == 0 && isPowerOfTwo(n / 2);
//        return n % 2 == 0 ? isPowerOfTwo(n/2) : false;
    }

    public boolean isPowerOfTwo_(int n) {
        return n != 0 && (n == 1 || n % 2 == 0 && isPowerOfTwo_(n / 2));
//        return n == 0 ? false : n == 1 ? true : n % 2 == 0 && isPowerOfTwo_(n / 2);
    }

    public boolean isPowerOfTwo2(int n) {
        if (n <= 0) return false;
        return (n-- & n) == 0;
    }

    public boolean isPowerOfTwo3(int n) {
        if (n <= 0) return false;
        return Integer.bitCount(n) == 1;
    }
}