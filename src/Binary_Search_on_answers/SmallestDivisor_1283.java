package Binary_Search_on_answers;

class SmallestDivisor_1283 {
    public static void main(String[] args) {

    }

    public int smallestDivisor(int[] nums, int threshold) {
        int start = 1;
//        int end = Arrays.stream(nums).max().orElse(0);
        int end = (int) 1E6;
        int ans = -1;
        while (start <= end) {
            int mid = (start + end) >>> 1;
            if (threshold(nums, mid) <= threshold) {
                ans = mid;
                end = mid - 1;
            }else {
                start = mid + 1;
            }
        }
        return ans;
    }

    private int threshold(int[] nums, int divisor) {
        int sum = 0;
        for (int num : nums) {
            int ceil = num/divisor;
            if (num % divisor != 0) {
                ceil++;
            }
            sum += ceil;
        }
        return sum;
    }
}