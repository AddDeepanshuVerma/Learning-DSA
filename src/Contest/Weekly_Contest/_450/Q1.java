package Contest.Weekly_Contest._450;

public class Q1 {

    public int smallestIndex(int[] nums) {
        int idx = -1;

        for (int i = 0; i < nums.length; i++) {
            if (i == digitSum(nums[i])) {
                return i;
            }
        }
        return idx;
    }

    private int digitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        Q1 obj = new Q1();

    }
}
