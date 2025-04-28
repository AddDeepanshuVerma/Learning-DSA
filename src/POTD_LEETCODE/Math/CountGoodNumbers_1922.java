package POTD_LEETCODE.Math;

class CountGoodNumbers_1922 {
    final int mod = (int) (1e9 + 7);

    //TC : log(n)
    public int countGoodNumbers2(long n) {
        long pow = n / 2;

        long first = (int) findPow(5, pow);
        long second = (int) findPow(4, pow);

        if ((n & 1) == 1) {
            return (int) ((((first * second) % mod) * 5) % mod);
        }

        return (int) ((first * second) % mod);
    }

    private long findPow(int a, long pow) {
        if (pow == 0) return 1;

        long half = findPow(a, pow / 2);

        long res = (half * half) % mod;
        if ((pow & 1) == 1) {
            res = (res * a) % mod;
        }
        return res;
    }

    //TC : O(n)
    public int countGoodNumbers(long n) {
        final int mod = (int) (1e9 + 7);
        long count = 1, prev = 4;
        while (n-- > 0) {
            if (prev == 4) {
                count *= 5;
                prev = 5;
            } else {
                count *= 4;
                prev = 4;
            }
            count = count % mod;
        }
        return (int) count;
    }

    public static void main(String[] args) {
        var obj = new CountGoodNumbers_1922();
        for (int i = 0; i < 20; i++) {
            int ans = obj.countGoodNumbers(i);
            System.out.println(i + " : " + ans);
        }
    }
}