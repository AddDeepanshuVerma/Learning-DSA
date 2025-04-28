package POTD_LEETCODE.Array_Difference;

class MinZeroArray_3356_2 {
    public static void main(String[] args) {
        int[] nums = {7, 6, 8};
        int[][] queries = {{0, 0, 2}, {0, 1, 5}, {2, 2, 5}, {0, 2, 4}};
        System.out.println(minZeroArray(nums, queries));
    }

    // O(NlogN)
    public static int minZeroArray(int[] nums, int[][] queries) {
        // As we need to find the min index of queries as it is sorted hence let apply Binary Search
        /*
         * edge case : check if nums array is already as our expected answer
         * which we can either vie running a loop on nums and finding not element is greater than 0
         * or simply running our solve function for k == -1 as it's the case when queries wouldn't be looped
         * */
        if (gotOurAnswer(-1, nums, queries)) return 0;

        int start = 0, end = queries.length - 1;
        int ans = -1; // if no answer was found
        while (start <= end) {
            int mid = (start + end) >> 1;
            if (zeroArrayFound(mid, nums, queries)) { // if answer is found store it and look for smaller one
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans == -1 ? -1 : ans + 1; //as our mid as an index is included in gotOurAnswer function
    }

    // O(N)
    private static boolean zeroArrayFound(int k, int[] nums, int[][] queries) {
        int n = nums.length;
        int[] preFix = new int[n + 1];

        for (int i = 0; i <= k; i++) {
            int l = queries[i][0], r = queries[i][1], d = queries[i][2];
            preFix[l] += d;
            preFix[r + 1] -= d;
        }

        // now check the difference from this preFix array - nums array
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += preFix[i]; // applying the preFix on preFix array in single go
            if (nums[i] > sum) return false;
        }
        return true;
    }

    private static boolean gotOurAnswer(int k, int[] nums, int[][] queries) {
        int n = nums.length;
        int[] preFix = new int[n + 1];

        for (int i = 0; i <= k; i++) {
            int l = queries[i][0], r = queries[i][1], d = queries[i][2];
            preFix[l] += d;
            preFix[r + 1] -= d;
        }

        for (int i = 1; i < preFix.length; i++) {
            preFix[i] += preFix[i - 1];
        }

        // now check the difference from this preFix array - nums array
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > preFix[i]) return false;
        }
        return true;
    }
}