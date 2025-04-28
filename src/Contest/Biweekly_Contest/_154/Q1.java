package Contest.Biweekly_Contest._154;

import java.util.Arrays;

public class Q1 {
    public int minOperations(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        return sum % k;
    }

    public static void main(String[] args) {
        Q1 obj = new Q1();
    }
}
