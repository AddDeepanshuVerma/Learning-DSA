package DailyCodeChallenge;

public class NumSteps_1404 {
    public static void main(String[] args) {
        System.out.println(numSteps("1111011110000011100000110001011011110010111001010111110001"));
    }

    public static int numSteps(String s /* 1101 */) {
        int n = s.length() - 1;
        long sum = 0, temp = 1;
        for (int i = n; i >= 0; i--) {
            char c = s.charAt(i);
            if (Character.getNumericValue(c) == 1) {
                sum += temp;
            }
            temp *= 2;
        } 
        System.out.println(sum);
        int count = 0;
        while (sum > 1) {
            if (sum % 2 != 0) {
                sum++;
                count++;
            }
            sum /= 2;
            count++;
        }
        return count;
    }
}
