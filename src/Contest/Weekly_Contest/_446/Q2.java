package Contest.Weekly_Contest._446;

public class Q2 {

    public int maximumPossibleSize(int[] nums) {
        int size = 1;
        int n = nums.length;
        int max = nums[0];

        for (int i = 1; i < n; i++) {
            while (i < n) {
                if (nums[i] >= max) {
                    max = nums[i];
                    size++;
                    break;
                }
                i++;
            }
        }
        return size;
    }

    public static void main(String[] args) {
        Q2 obj = new Q2();

        int[] nums = {50, 100, 100, 100};
        int size = obj.maximumPossibleSize(nums);
        System.out.println("size = " + size);
    }
}
