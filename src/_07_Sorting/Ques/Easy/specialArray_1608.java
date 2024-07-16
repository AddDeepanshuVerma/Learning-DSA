package _07_Sorting.Ques.Easy;

import java.util.Arrays;

class specialArray_1608 {
    public static void main(String[] args) {
        int[] num = {3, 5};
        System.out.println(specialArray2(num));
    }

    private static int specialArray2(int[] nums) {
        int maxElement = Arrays.stream(nums).max().getAsInt();
        int[] arr = new int[maxElement+1];
        for (int num : nums) {
            arr[num]++;
        }
        if (arr[arr.length - 1] == arr.length - 1) {
            return arr.length - 1;
        }
        for (int i = arr.length - 2; i > 0; i--) {
            arr[i] += arr[i + 1];
            if (arr[i] == i) {
                return i;
            }
        }
        return -1;
    }

    public static int specialArray(int[] nums) {
        int maxElement = Arrays.stream(nums).max().getAsInt();
        int[] arr = new int[maxElement+1];
        Arrays.stream(nums).forEach(n -> arr[n]++);
        if (arr[arr.length - 1] == arr.length - 1) {
            return arr.length - 1;
        }
        for (int i = arr.length - 2; i > 0; i--) {
            arr[i] += arr[i + 1];
            if (arr[i] == i) {
                return i;
            }
        }
        return -1;
    }
}