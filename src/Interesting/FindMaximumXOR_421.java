package Interesting;

class FindMaximumXOR_421 {
    public static void main(String[] args) {
        System.out.println(Long.toBinaryString(Long.MAX_VALUE));
        System.out.println(Integer.toBinaryString(2147483647));
        String str = "01000000000000000000000000000000";
        String string = new StringBuilder(str).reverse().toString();
        System.out.println(Integer.parseInt(str, 2));
        System.out.println(Integer.parseInt(string, 2));

    }

    public int findMaximumXOR(int[] nums) {
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int temp = nums[i] ^ nums[j];
                ans = Math.max(ans, temp);
            }
        }
        return ans;
    }

}