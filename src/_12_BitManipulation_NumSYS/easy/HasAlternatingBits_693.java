package _12_BitManipulation_NumSYS.easy;

class HasAlternatingBits_693 {
    public boolean hasAlternatingBits(int n) {
        n = n ^ (n >> 1);
        return (n & n + 1) == 0;
    }

    public boolean hasAlternatingBits2(int n) {
        int previousBit = n & 1;
        n >>= 1;
        while (n > 0) {
            int currentBit = n & 1;
            if (previousBit == currentBit) {
                return false;
            }
            previousBit = currentBit;
            n >>= 1;
        }
        return true;
    }
}