package Sorting_07.Ques.Easy;

import java.util.Arrays;

class frequencySort_1636 {
    public static void main(String[] args) {
        int[] num = {2,3,1,3,2};
        System.out.println(Arrays.toString(frequencySort(num)));
    }

    public static int[] frequencySort(int[] nums) {
        int[] arr = new int[250];
        int maxFreq = 0;
        for (int num : nums) {
            arr[num + 110]++;
            maxFreq = Math.max(maxFreq, arr[num + 110]);
        }
        int k = 0;
        for (int i = 1; i <= maxFreq; i++) {
            for (int j = arr.length-1; j >0; j--) {
                if (arr[j] == i) {
                    while (arr[j] > 0) {
                        nums[k] = j-110;
                        arr[j] = arr[j] -1;
                        k++;
                    }
                }
            }
        }
        /*for (int i = 1; i <= maxFreq; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == i) {
                    while (arr[j] > 0) {
                        nums[k] = j-100;
                        arr[j] = arr[j] -1;
                        k++;
                    }
                }
            }
        }*/
        return nums;
    }
}