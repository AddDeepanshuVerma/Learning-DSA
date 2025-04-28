package Contest.Weekly_Contest._420;

public class Q3 {
    public static void main(String[] args) {
        Q3 obj = new Q3();
        int[] ans = {7, 7, 6};
        System.out.println(obj.minOperations(ans));
    }

    public int minOperations(int[] nums) {
        int count = 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] <= nums[i + 1]) {
                continue;
            }
            int gpd = getGreatestProperDivisor(nums[i], nums[i+1]);
            if (gpd > nums[i + 1]) {
                return -1;
            } else {
                nums[i] = gpd;
                count++;
            }
        }
        return count;
    }

    private int getGreatestProperDivisor(int num, int k) {
        if (num == 1) return 1;
        int ans = num;
        int sqrt = (int) Math.sqrt(num);
        for (int i = sqrt; i > 1; i--) {
            if (num % i == 0 && i <= k) {
                return i;
            }
        }
        return ans;
    }
}
