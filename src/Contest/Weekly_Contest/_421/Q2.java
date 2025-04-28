package Contest.Weekly_Contest._421;

public class Q2 {
    public static void main(String[] args) {
        Q2 obj = new Q2();
    }

    private long gcd(long x, long y) {
        while (y != 0) {
            long temp = y;
            y = x % y;
            x = temp;
        }
        return x;
    }

    private long lcm(long x, long y) {
        return (x / gcd(x, y)) * y;
    }

    private long computeArrayLCM(int[] numbers) {
        if (numbers.length == 0) return 1;
        long resultLCM = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            resultLCM = lcm(resultLCM, numbers[i]);
        }
        return resultLCM;
    }

    public long maxScore(int[] numbers) {
        int size = numbers.length;
        if (size == 1) {
            // a * b = LCM * GCD
            return (long) numbers[0] * numbers[0];
        }

        int overallGCD = numbers[0];
        long overallLCM = computeArrayLCM(numbers);

        for (int i = 1; i < size; i++) {
            overallGCD = (int) gcd(overallGCD, numbers[i]);
        }

        long maxScore = (long) overallGCD * overallLCM;

        for (int i = 0; i < size; i++) {
            int tempGCD = 0;
            int[] remainingNumbers = new int[size - 1];
            int index = 0;

            for (int j = 0; j < size; j++) {
                if (j != i) {
                    remainingNumbers[index++] = numbers[j];
                    tempGCD = tempGCD == 0 ? numbers[j] : (int) gcd(tempGCD, numbers[j]);
                }
            }

            long currentLCM = computeArrayLCM(remainingNumbers);
            long currentScore = (long) tempGCD * currentLCM;
            maxScore = Math.max(maxScore, currentScore);
        }

        return maxScore;
    }

}
