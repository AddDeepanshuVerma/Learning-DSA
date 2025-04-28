package POTD_LEETCODE.BitManipulation;

class DoesValidArrayExist_2683 {
    public boolean doesValidArrayExist(int[] derived) {
        /*
         * the array we are given B, would be derived from an array A
         * only if the xor of this array is 0 because if the process of deriving the array
         * is each element got xored twice and those xored gets xor again must give us zero
         *  */

        int r = 0;
        for (int n : derived)
            r ^= n;
        return r == 0;
    }
}