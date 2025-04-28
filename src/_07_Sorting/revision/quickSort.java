package _07_Sorting.revision;

import java.util.Arrays;

public class quickSort {

    public void sort(int[] nums) {
        quickSortAsc(0, nums.length - 1, nums);
    }

    private void quickSortAsc(int start, int end, int[] nums) {
        if (start >= end) return;
        int pivotIndex = findPivot(start, end, nums);
        quickSortAsc(start, pivotIndex - 1, nums);
        quickSortAsc(pivotIndex + 1, end, nums);
    }

    public int findPivot(int firstIndex, int lastIndex, int[] arr) {
        int pivot = arr[firstIndex];
        int i = firstIndex + 1; // Start from the next index
        int j = lastIndex;

        while (i <= j) {
            // Move i forward while arr[i] is less than pivot
            while (i <= lastIndex && arr[i] < pivot) {
                i++;
            }

            // Move j backward while arr[j] is greater than or equal to pivot
            while (j > firstIndex && arr[j] >= pivot) {
                j--;
            }

            // If i <= j, swap the elements
            if (i < j) {
                swap(arr, i, j);
            }
        }

        // Swap the pivot element into the correct position
        swap(arr, firstIndex, j);

        return j;  // Return the pivot's final position
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        quickSort obj = new quickSort();
//        int[] nums = {1, 2, 3, 4, 5, 1, 1, 1, -5, -4, -3, -2, -1};
        int[] nums = {110, 100, 0};
        obj.sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
