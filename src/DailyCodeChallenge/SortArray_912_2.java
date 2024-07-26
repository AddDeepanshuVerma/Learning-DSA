package DailyCodeChallenge;

import java.util.Arrays;

class SortArray_912_2 {
    public static void main(String[] args) {
        int[] nums = {5, 9, 8, 7, 6};
//        int[] result = mergeSort(nums);
        int start = 0;
        int end = nums.length - 1;
        quickSort(nums, start, end);
        System.out.println(Arrays.toString(nums));
    }

    public static int[] sortArray(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        quickSort(nums, start, end);
        return nums;
    }

    private static void quickSort(int[] nums, int start, int end) {
        if (start >= end) return;

        int indexOfPivot = partitioning(nums, start, end);
        quickSort(nums, start, indexOfPivot - 1);
        quickSort(nums, indexOfPivot + 1, end);
    }

    private static int partitioning(int[] nums, int firstIndex, int end) {
        int pivot = nums[firstIndex];
        int i = firstIndex;
        int j = end;
        while (i <= j) {
            if (nums[i] > pivot && nums[j] < pivot) swap(nums, i++, j--);
            else if (nums[i] <= pivot) i++;
            else if (nums[j] >= pivot) j--;
        }
        swap(nums, firstIndex, j);
        return j;
    }

    private static void swap(int[] nums, int first, int last) {
        int temp = nums[first];
        nums[first] = nums[last];
        nums[last] = temp;
    }

}
