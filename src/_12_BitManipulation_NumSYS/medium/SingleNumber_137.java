package _12_BitManipulation_NumSYS.medium;

class SingleNumber_137 {
    public static void main(String[] args) {
        int[] arr = {-2, -2, 1, 1, 4, 1, 4, 4, -4, -2};
        System.out.println(singleNumber(arr));
    }

    public static int singleNumber(int[] nums) {
        int ans = 0;

        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int num : nums)
                count += (num >> i) & 1;
            count %= 3;
            ans = ans | (count << i);
        }

        return ans;
    }

    // not getting correct answer with negative values
    // 1. Integer.parseInt doesn't work with values till 32th bit
    // 2. Hence, need to store bits in String but in int itself
    // 3. MaxDigit will be a scam as for negative number we wouldn't get correct ans
    // 4. Hence, need to run loop till 32th bit manually and each time
    public static int singleNumber2(int[] nums) {
        int maxDigit = Integer.MIN_VALUE;
        for (int num : nums) {
            maxDigit = Math.max(maxDigit, num);
        }
        maxDigit = (int) (Math.log(maxDigit) / Math.log(2)) + 1;

        String ans = "";
        int base = 3;
        for (int i = 0; i <= maxDigit; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                count += (nums[j] & 1) == 1 ? 1 : 0;
                nums[j] >>= 1;
            }
            ans = (count % base) + ans;
        }
        return Integer.parseInt(ans, 2);
    }

}