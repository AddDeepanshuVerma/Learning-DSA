package _12_BitManipulation_NumSYS.medium;

class Divide_29 {
    public static void main(String[] args) {
        int dividend = -2147483648;
        int divisor = 1;
        System.out.println(divide(dividend, divisor));
    }

    private static int divide(long dividend, long divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;

        final boolean sign = dividend > 0 ^ divisor > 0;
        int ans = 0;
        long num = Math.abs(dividend);
        long d = Math.abs(divisor);

        while (num >= d) {
            int count = 0;
            while (d << (count + 1) <= num) {
                count++;
            }
            ans += 1 << count;
            num -= d << count;
        }
        return sign ? -ans : ans;
    }

    private static int divide3(int dividend, int divisor) {
        // -2^{31} / -1 = 2^31 will overflow, so return 2^31 - 1.
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;

        final int sign = dividend > 0 ^ divisor > 0 ? -1 : 1;
        long ans = 0;
        long num = Math.abs(dividend);
        long d = Math.abs(divisor);

        while (num >= d) {
            long k = 1;
            while (k * 2 * d <= num) k *= 2;
            num -= k * d;
            ans += k;
        }
        return sign * (int) ans;
    }

}