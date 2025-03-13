package _13_Maths.Algo;

import java.util.Arrays;

class PrimeNumbers {
    static boolean[] isPrime;

    public static void main(String[] args) {
        // print prime number from 0 till n
        sieve(50);
    }

    public static void sieve(int n) {
        isPrime = new boolean[n + 1];

        Arrays.fill(isPrime, true);                 // initially considering all numbers are prime
        isPrime[0] = isPrime[1] = false;                // 0 and 1 are not prime

        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {                           // if it is prime then its table is not
                for (int j = i * i; j <= n; j += i) {   // starting with i^2 as earlier index must have already covered
                    isPrime[j] = false;                 // table of i^2 would not be prime
                }
            }
        }

        for (int i = 0; i < isPrime.length; i++) {
            if (isPrime[i]) {
                System.out.println(i + " ");
            }
        }

    }
}