package POTD_LEETCODE.Math;

class CountGoodNumbers_1922_2 {
    final int M = (int) (1e9 + 7);

    //TC : log(n)
    public int countGoodNumbers2(long n) {
        long first = (int) findPow(5, (n + 1) >> 1);
        long second = (int) findPow(4, n >> 1);
        return (int) ((first * second) % M);
    }

    private long findPow(int a, long pow) {
        if (pow == 0) return 1;

        long half = findPow(a, pow / 2);
        long res = (half * half) % M;

        if ((pow & 1) == 1) {
            res = (res * a) % M;
        }

        return res;
    }

    public static void main(String[] args) {
        var obj = new CountGoodNumbers_1922_2();
        for (int i = 0; i < 20; i++) {
            int ans = obj.countGoodNumbers2(i);
            System.out.println(i + " : " + ans);
        }
    }
}