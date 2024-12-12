package POTD_LEETCODE.Array;

import jdk.jfr.Description;

import java.util.Arrays;
import java.util.HashMap;

class Solution_2779 {
    public static void main(String[] args) {
        int[] nums = {81, 76, 40};
        System.out.println(maximumBeauty2(nums, 5));
    }

    @Description("n^2, traversing two loop, using map to store all possible values")
    public static int maximumBeauty(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = -1;
        for (int num : nums) {
            for (int j = num - k; j <= num + k; j++) {
                int val = map.merge(j, 1, Integer::sum);
                ans = Math.max(ans, val);
            }
        }
        return ans;
    }

    @Description("nlogn")
    public static int maximumBeauty2(int[] nums, int k) {
        nums = mergeSort(nums);
//        quickSort(nums);
//        Arrays.sort(nums);
        int ans = 1;
        k <<= 1;
        for (int i = 0; i < nums.length; i++) {
            int lastIndex = binarySearch(nums, nums[i] + k + 1);
            ans = Math.max(ans, lastIndex - i + 1);
        }
        return ans;
    }

    @Description("find lastIndex lesser then val")
    private static int binarySearch(int[] nums, int val) {
        int start = 0;
        int end = nums.length - 1;
        int ans = -1;

        while (start <= end) {
            int mid = (start + end) >>> 1;
            if (nums[mid] < val) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }

    //========================= merge Sort ============================

    private static int[] mergeSort(int[] nums) {
        if (nums.length == 1) return nums;
        int mid = nums.length >> 1;
        int[] left = mergeSort(Arrays.copyOfRange(nums, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(nums, mid, nums.length));
        return merge(left, right);
    }

    private static int[] merge(int[] left, int[] right) {
        int[] res = new int[left.length + right.length];
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) res[k++] = left[i++];
            else res[k++] = right[j++];
        }
        while (i < left.length) res[k++] = left[i++];
        while (j < right.length) res[k++] = right[j++];
        return res;
    }

    //========================= quick Sort ============================

    private static void quickSort(int[] nums) {
        int start = 0;
        quick(start, nums.length - 1, nums);
    }

    private static void quick(int left, int right, int[] nums) {
        if (left < right) {
            int pivotIndex = partition(nums, left, right);
            quick(left, pivotIndex - 1, nums);
            quick(pivotIndex + 1, right, nums);
        } else {
            return;
        }
    }

    private static int partition(int[] nums, int firstIndex, int high) {
        int pivot = nums[firstIndex];
        int i = firstIndex;
        int j = high;
        while (i <= j) {
            if (nums[i] > pivot && nums[j] < pivot) swap(nums, i++, j--);
            else if (nums[i] <= pivot) i++;
            else if (nums[j] >= pivot) j--;
        }
        swap(nums, firstIndex, j);
        return j;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}