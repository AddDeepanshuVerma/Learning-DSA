package Contest.Biweekly_Contest._154;

public class Q2 {
    public int uniqueXorTriplets(int[] nums) {
        // add all xor of all elements
        int xor = nums[0];
        for (int i = 1; i < nums.length; i++) {
            xor ^= nums[i];
        }

        return xor == 0 ? nums.length + 1 : nums.length;
    }

    public int uniqueXorTriplets2(int[] nums) {
        int n = nums.length;
        int bit = Integer.highestOneBit(n);
        return n < 3 ? n : bit << 1;
    }

    public static void main(String[] args) {
        Q2 obj = new Q2();
        int[] nums = {3, 1, 2, 4};
        int ans = obj.uniqueXorTriplets2(nums);
        System.out.println(ans);
    }
}

