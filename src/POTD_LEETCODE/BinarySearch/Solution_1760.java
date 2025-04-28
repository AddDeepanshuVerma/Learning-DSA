package POTD_LEETCODE.BinarySearch;

class Solution_1760 {
    public int minimumSize(int[] nums, int maxOperations) {
        /*
         * Here we will apply binarySearch on maximum element that can be put in array
         * while the array sum is still the same and final array length <= (arr.length + maxOperations)
         *
         * meanwhile when we get the isPossible answer as true, we go with lower and lower values
         * */
        int sum = 0;
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            sum += num;
            max = Math.max(max, num);
        }
        int maxValidLength = nums.length + maxOperations;

        // now apply BS from [0, max]

        int start = 0, end = max;
        int ans = -1;

        while (start <= end) {
            int mid = (start + end) >>> 1;
            if (isValid(maxValidLength, sum, mid, nums)) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }

    private boolean isValid(int maxValidLength, int sum, int maxElement, int[] nums) {
        int count = 0;
        for (int num : nums) {
            count += num / maxElement;
            if (num % maxElement != 0) {
                count++;
            }
        }

        return count <= maxValidLength;
    }

}