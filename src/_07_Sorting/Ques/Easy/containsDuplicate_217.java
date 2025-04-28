package _07_Sorting.Ques.Easy;

import java.util.Arrays;

class containsDuplicate_217 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,1};
//        int[] ints = mergeSort(arr);
//        System.out.println(containsDuplicate(ints));
        System.out.println(containsDuplicate(arr));
    }

    public static boolean containsDuplicate(int[] nums) {
        nums = mergeSort(nums);
        System.out.println(Arrays.toString(nums));
        //search if any element appears twice, send true/false
        return findDuplicateElement(nums);
    }

    private static boolean findDuplicateElement(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return true;
            }
        }
        return false;
    }

    private static int[] mergeSort(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums;
        }
        int mid = n / 2;
        int[] left = mergeSort(Arrays.copyOfRange(nums, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(nums, mid, n));
        return merge(left, right);
    }

    private static int[] merge(int[] left, int[] second) {
        int l = left.length;
        int r = second.length;
        int[] res = new int[l + r];
        int i = 0, j = 0, k = 0;
        while (i < l && j < r) {
            if (left[i] < second[j]) {
                res[k++] = left[i++];
            } else {
                res[k++] = second[j++];
            }
        }
        while (i < l) {
            res[k++] = left[i++];
        }
        while (j < r) {
            res[k++] = second[j++];
        }
        return res;
    }
}