package POTD_LEETCODE.level_3;

class MinBitFlips_2220 {
    public int minBitFlips(int start, int goal) {
        int ans = start ^ goal;
        int count = 0;
        while (ans > 0) {
            count += ans & 1;
            ans >>= 1;
        }
        return count;
    }


    /*brian kernighan's algorithm :*/
    /* Subtracting 1 from a decimal number flips all the bits after the rightmost set bit(which is 1) including the rightmost set bit.
                for example :
                10 in binary is 00001010
                9 in binary is 00001001
                8 in binary is 00001000
                7 in binary is 00000111
                */
    public int minBitFlips2(int start, int goal) {
        int ans = start ^ goal;
        int count = 0;
        while (ans != 0) {
            ans = ans & (ans - 1);
            count++;
        }
        return count;
    }
}