package Sorting_07.Ques.Easy;

import java.util.Arrays;

class merge_88 {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] res = new int[nums1.length];
        int i = 0, j = 0, k = 0;
        while (i < m && j < n)
            if (nums1[i] <= nums2[j]) res[k++] = nums1[i++];
            else res[k++] = nums2[j++];
        while (i < m) res[k++] = nums1[i++];
        while (j < n) res[k++] = nums2[j++];

        System.arraycopy(res, 0, nums1, 0, res.length);
    }
}