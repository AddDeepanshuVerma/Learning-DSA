package _12_BitManipulation_NumSYS.easy;

public class ReverseBits_190 {
    // you need treat n as an unsigned value
    private static int reverseBits(int n) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1) ans = ans | (1 << (31 - i));
            n >>= 1;
        }
        return ans;
    }

    public static int reverseBits2(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append((n & 1) == 1 ? '1' : '0');
            n >>= 1;
        }
        while (sb.length() <= 32) sb.append('0');
        return Integer.parseInt(sb.toString(), 2);

    }
}