package _10_Recursion;

class sPowerOfFour_342 {
    public boolean isPowerOfFour(int n) {
        if(n<= 0) return false;
        if(n ==1 ) return true;
        return n % 4 == 0 && isPowerOfFour(n / 4);
    }

    public boolean isPowerOfFour2(int n) {
        if (n > 1) {
            return n % 4 == 0 && isPowerOfFour2(n / 4);
        }else {
            return n == 1;
        }
    }

    public boolean isPowerOfFour3(int n) {
        return n > 1 ? n % 4 == 0 && isPowerOfFour3(n / 4) : n == 1;
    }
}
