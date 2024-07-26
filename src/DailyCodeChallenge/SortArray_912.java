package DailyCodeChallenge;

import java.util.Arrays;

class SortArray_912 {
    public static void main(String[] args) {
        int[] nums = {5, 1, 1, 2, 0, 0};
        int[] result = mergeSort(nums);
//        int[] result = quickSort(nums);
        System.out.println(Arrays.toString(result));
    }

    public static int[] sortArray(int[] nums) {
        return mergeSort(nums);
    }

    private static int[] mergeSort(int[] nums) {
        if (nums.length == 1) return nums;
        int mid = nums.length >> 1;
        int[] left = mergeSort(Arrays.copyOfRange(nums, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(nums, mid, nums.length));
        return merge(left, right);
    }

    private static int[] merge(int[] left, int[] right) {
        int[] res = new int[left.length + right.length];
        int k = 0, l = 0, r = 0;
        while (l < left.length && r < right.length)
            if (left[l] < right[r]) res[k++] = left[l++];
            else res[k++] = right[r++];
        while (l < left.length) res[k++] = left[l++];
        while (r < right.length) res[k++] = right[r++];
        return res;
    }

/*
    public static int[] sortArray2(int[] nums) {
        return mergeSort2(nums);
//        return quickSort(nums);
    }
    private static int[] mergeSort2(int[] nums) {
        if (nums.length == 1) return nums;
        int mid = nums.length >> 1;

        int[] first = mergeSort2(Arrays.copyOfRange(nums, 0, mid));
        int[] second = mergeSort2(Arrays.copyOfRange(nums, mid, nums.length));

        return merge2(first, second);
    }
    private static int[] merge2(int[] first, int[] second) {
        int[] res = new int[first.length + second.length];
        int k = 0, n1 = 0, n2 = 0;
        while (n1 < first.length && n2 < second.length) {
            if (first[n1] < second[n2]) {
                res[k] = first[n1];
                n1++;
            } else {
                res[k] = second[n2];
                n2++;
            }
            k++;
        }
        while (n1 < first.length) {
            res[k] = first[n1];
            k++;
            n1++;
        }
        while (n2 < second.length) {
            res[k] = second[n2];
            k++;
            n2++;
        }
        return res;
    }*/

}
