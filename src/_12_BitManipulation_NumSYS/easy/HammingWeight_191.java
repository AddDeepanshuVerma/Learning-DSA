package _12_BitManipulation_NumSYS.easy;

class HammingWeight_191 {

    public int hammingWeight(int n) {
        int count = 0;
        while (n > 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n >>= 1;
        }
        return count;
    }

    public int hammingWeight2(int n) {
        int count = 0;
        while (n > 0) {
            count++;
            n = n - (n & -n);
        }
        return count;
    }
}