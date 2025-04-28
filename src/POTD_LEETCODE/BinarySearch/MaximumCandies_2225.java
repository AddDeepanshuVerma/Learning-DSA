package POTD_LEETCODE.BinarySearch;

class MaximumCandies_2225 {
    public static void main(String[] args) {
        int[] candies = {5, 8, 6};
        int k = 3;
        int ans = new MaximumCandies_2225().maximumCandies(candies, k);
        System.out.println("ans = " + ans);
    }

    public int maximumCandies(int[] candies, long k) {
        long sum = 0;
        int max = Integer.MIN_VALUE;
        for (int candy : candies) {
            sum += candy;
            max = Math.max(max, candy);
        }

        if (sum < k) return 0; // edge case: if there are in total less candy then no of child

        int start = 1; // at least one can be given as sum is higher
        int end = max; // as we can not combine 2 piles of candy hence max candy that can be given to a child is maxPile available
        int ans = 0;

        while (start <= end) {
            int mid = (start + end) >> 1;
            if (candiesDivided(mid, k, candies)) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }

    private boolean candiesDivided(int minCandy, long minChild, int[] candies) {
        long childSatfified = 0;
        for (int candy : candies) {
            childSatfified += candy / minCandy;
            if (childSatfified >= minChild) {
                return true;
            }
        }
        return false;
    }
}