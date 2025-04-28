package Contest.Biweekly_Contest._141;

public class EventWays {

    private static final int MOD = 1000000007;

    public static long totalWays(int n, int x, int y) {
        // Calculate x^n % MOD
        long waysToAssignStages = modPow(x, n, MOD);
        
        // Calculate y^min(n, x) % MOD
        long waysToAssignScores = modPow(y, Math.min(n, x), MOD);
        
        // Total ways is the product of the two
        return (waysToAssignStages * waysToAssignScores) % MOD;
    }

    // Function to compute (base^exp) % mod using fast exponentiation
    private static long modPow(int base, int exp, int mod) {
        long result = 1;
        long power = base % mod;
        
        while (exp > 0) {
            if ((exp & 1) == 1) { // If exp is odd
                result = (result * power) % mod;
            }
            power = (power * power) % mod; // Square the base
            exp >>= 1; // Divide exp by 2
        }
        return result;
    }

    public static void main(String[] args) {
        // Example inputs
        System.out.println(totalWays(1, 2, 3)); // Output: 6
        System.out.println(totalWays(5, 2, 1)); // Output: 32
        System.out.println(totalWays(3, 3, 4)); // Output: 684
    }
}
