package DailyCodeChallenge.Sorting;

import java.util.Arrays;

class CountFairPairs_2563 {
    public static void main(String[] args) {
        CountFairPairs_2563 obj = new CountFairPairs_2563();
        int[] arr = {5, 4, 3, 2, 1, 54, 112, 23, 21, 445, 212, 55, 3, 2, 1, 3, 5, 45, 56, 3, 2, 2, 3};
        obj.quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

    }

    // O(n^2)
    public long countFairPairs(int[] nums, int lower, int upper) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int sum = nums[i] + nums[j];
                if (lower <= sum && sum <= upper) {
                    count++;
                }
            }
        }
        return count;
    }

    // O(nlogn)
    public long countFairPairs2(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
//        quickSort(nums, 0, nums.length - 1);
        return countPair(nums, upper) - countPair(nums, lower - 1);
    }

    private int countPair(int[] nums, int max) {
        int start = 0, end = nums.length - 1;
        int ans = 0;
        while (start <= end) {
            int sum = nums[start] + nums[end];
            if (sum <= max) {
                ans += end - start;
                start++;
            } else {
                end--;
            }
        }
        return ans;
    }

    //======================= quick sort =======================

    private void quickSort(int[] nums, int left, int right) {
        if (left >= right) return;
        int pivotIndex = partition(nums, left, right);
        quickSort(nums, left, pivotIndex - 1);
        quickSort(nums, pivotIndex + 1, right);
    }

    private int partition(int[] nums, int firstIndex, int high) {
        int pivot = nums[firstIndex];
        int i = firstIndex + 1, j = high;
        while (i <= j) {
            if (nums[i] >= pivot && nums[j] <= pivot) swap(nums, i++, j--);
            else if (nums[i] <= pivot) i++;
            else if (nums[j] >= pivot) j--;
        }
        swap(nums, firstIndex, j);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}