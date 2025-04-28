package _07_Sorting.revision;

import jdk.jfr.Description;

import java.util.Arrays;

public class quickSort_shortForm {

    @Description("Quick sort worst case time complexity is n^2, Merge sort is more efficient for Large Arrays")
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
        int i = firstIndex + 1;
        int j = lastIndex;
        while (i <= j) {
            while (i <= lastIndex && arr[i] < pivot) i++;
            while (j > firstIndex && arr[j] >= pivot) j--;
            if (i < j) swap(arr, i, j);
        }
        swap(arr, firstIndex, j);
        return j;
    }

    public static void main(String[] args) {
        quickSort_shortForm obj = new quickSort_shortForm();
        int[] nums = {1, 2, 3, 4, 5, 1, 1, 1, -5, -4, -3, -2, -1};
        obj.sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
