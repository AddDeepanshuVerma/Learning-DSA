package Top_Interview_150;

import java.util.Arrays;

class RemoveElement_27 {
    public static void main(String[] args) {
        int[] arr = {3, 2, 2, 3};
        System.out.println(RemoveElement_27.removeElement(arr, 3));

    }
    public static int removeElement(int[] nums, int val) {
        int[] arr = new int[102];
        for (int num : nums)
            arr[num]++;
        arr[val] = 0; int j = 0;
        for (int i = 0; i < arr.length; i++) {
            while (arr[i] > 0) {
                nums[j++] = i;
                arr[i]--;
            }
        }
        System.out.println(Arrays.toString(nums));
        return j;
    }
}