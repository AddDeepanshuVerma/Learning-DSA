package Sorting_07.Ques.Easy;

import java.util.Arrays;

class sortArrayByParity_905 {
    public static void main(String[] args) {
        int[] arr = {3,1,2,4,4,3,2,3,4,5,4,2,2,54,565,4,342,12,3,45};
        System.out.println(Arrays.toString(sortArrayByParity3(arr)));
    }

    private static int[] sortArrayByParity3(int[] arr) {
            for (int i = 0; i < arr.length - 1; i++) {
                for (int j = i + 1; j > 0; j--) {
                    if (arr[j]%2==0) {
                        swap(arr, j, j - 1);
                    }else break;
                }
            }
        return arr;
    }


    private static int[] sortArrayByParity2(int[] arr) {
        int i = 0, j = arr.length-1;
        while (i < j) {
            if (arr[i] % 2 == 0) {
                i++;
            } else if (arr[j] % 2 != 0) {
                j--;
            } else if (arr[i] % 2 != 0 && arr[j] % 2 == 0) {
                swap(arr, i, j);
                i++;j--;
            }
        }
        return arr;
    }


    public static int[] sortArrayByParity(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int index = 0, max = Integer.MIN_VALUE;
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j]%2 != 0) {
                    index = j;
                    break;
                }
            }
            swap( arr , index , arr.length - i - 1);
        }
        return arr;
    }
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}