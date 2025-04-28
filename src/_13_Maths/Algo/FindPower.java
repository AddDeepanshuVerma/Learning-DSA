package _13_Maths.Algo;

public class FindPower {
    // when we need to multiply a, n times; we run the loop n time Hence TC : O(n)
    // But using (Binary/Fast Exponentiation) concept, we can find a multiply n times in log(n) base 2 time Hence TC : log(n)

    private long findPow(int a, long n) {
        if (n == 0) return 1;       // a^0 = 1

        long half = findPow(a, n / 2);

        long res = (half * half);
        if ((n & 1) == 1) {
            res = (res * a);        // if a^5 = a * a^(5/2) * a^(5/2)
        }
        return res;
    }
}
